package de.hsos.shipping.gateway;

import de.hsos.ordermanagement.acl.ShipLink;
import de.hsos.ordermanagement.entity.Orders;
import de.hsos.ordermanagement.utils.eventdto.CreateEventDTO;
import de.hsos.ordermanagement.utils.eventdto.DeleteEventDTO;
import de.hsos.ordermanagement.utils.eventdto.UpdateEventDTO;
import de.hsos.shipping.entity.IShippingCatalogue;
import de.hsos.shipping.entity.OrderAccepted;
import de.hsos.shipping.entity.Ship;
import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;
import de.hsos.shipping.utils.eventdto.ShipWithOrderIdDTO;
import de.hsos.shipping.utils.uri.UriBuilder;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.*;


@ApplicationScoped
public class ShippingRepository implements IShippingCatalogue {

    EntityManager entityManager;

    @Inject
    Event<ShipWithOrderIdDTO> orderAcceptedEvent;


    public ShippingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Collection<ShipDTO> getAllShips() {

        Collection<Ship> s = entityManager.createNamedQuery("Ships.findAll", Ship.class).getResultList();
        List<ShipDTO> dtoList = new ArrayList<>();


        for (Ship ship : s) {
            dtoList.add(ShipDTO.toDTO(ship));
        }

        return dtoList;
    }

    @Override
    public ShipDTO getShip(Integer id) {
        Ship ship = this.entityManager.find(Ship.class, id);

        if (ship == null) {
            return null;
        } else {
            return ShipDTO.toDTO(ship);
        }
    }


    @Override
    @Transactional
    public boolean createShip(PostShipDTOWithId postShipDTO) {

        Ship ship = PostShipDTOWithId.fromDTO(postShipDTO);
        this.entityManager.persist(ship);

        return true;
    }


    @Transactional
    private Integer getFreeShip() {


        Collection<Ship> ships = entityManager.createNamedQuery("Ships.findAll", Ship.class).getResultList();

        for (Ship s : ships) {
            if (!s.isHasOrder()) {
                Ship foundShip = this.entityManager.find(Ship.class, s.getId());

                System.out.println(foundShip.isHasOrder());
                foundShip.setHasOrder(true);
                System.out.println(foundShip.isHasOrder());

                return foundShip.getId();
            }
        }

        return null;
    }

    @Transactional
    public void getCreateOrder(@ObservesAsync CreateEventDTO createEventDTO) {

        Integer freeShipId = getFreeShip();
        Ship freeShip = this.entityManager.find(Ship.class, freeShipId);

        if (freeShip != null) {
            ShipWithOrderIdDTO shipWithOrderIdDTO = new ShipWithOrderIdDTO(freeShip.getId(), freeShip.getName(), freeShip.isHasOrder(), freeShip.getShipLink(), createEventDTO.id);
            this.orderAcceptedEvent.fireAsync(shipWithOrderIdDTO);
        } else {
            System.out.println("No free ships available");
        }
    }

    @Transactional
    public void getDeleteEvent(@ObservesAsync DeleteEventDTO deleteEventDTO) {
        Ship freeShip = this.entityManager.find(Ship.class, deleteEventDTO.id);
        System.out.println(deleteEventDTO.description + " has been removed from Ship with ID" + deleteEventDTO.id);
        freeShip.setHasOrder(false);
    }


    public void getUpdate(@ObservesAsync UpdateEventDTO updateEventDTO) {
        System.out.println("Description has been changed to " + updateEventDTO.description);
    }


}
