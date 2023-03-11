package de.hsos.ordermanagement.gateway;

import de.hsos.ordermanagement.entity.CreateEvent;
import de.hsos.ordermanagement.entity.IOrderCatalogue;
import de.hsos.ordermanagement.entity.Orders;
import de.hsos.ordermanagement.utils.dto.*;
import de.hsos.ordermanagement.utils.eventdto.CreateEventDTO;
import de.hsos.ordermanagement.utils.eventdto.DeleteEventDTO;
import de.hsos.ordermanagement.utils.eventdto.UpdateEventDTO;
import de.hsos.playground.Student;
import de.hsos.shipping.entity.OrderAccepted;
import de.hsos.shipping.entity.Ship;
import de.hsos.shipping.utils.eventdto.ShipWithOrderIdDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
public class OrderRepository implements IOrderCatalogue {


    EntityManager entityManager;

    @Inject
    Event<CreateEventDTO> createEvent;

    @Inject
    Event<DeleteEventDTO> deleteEvent;

    @Inject
    Event<UpdateEventDTO> updateEvent;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<GetAllOrderDTO> getAllOrders() {

        Collection<Orders> o = entityManager.createNamedQuery("Orders.findAll", Orders.class).getResultList();
        List<GetAllOrderDTO> dtoList = new ArrayList<>();

        for (Orders order : o) {
            dtoList.add(GetAllOrderDTO.toDTO(order));
        }

        return dtoList;
    }

    @Override
    public GetOrderDTO getOrder(Integer id) {

        Orders order = this.entityManager.find(Orders.class, id);

        if (order == null) {
            return null;
        } else {
            return GetOrderDTO.toDTO(order);
        }
    }

    @Override
    @Transactional
    public boolean createOrder(PostOrderWithIdDTO postOrderWithIdDTO) {

        Date date = new Date();
        Orders order = new Orders(postOrderWithIdDTO.id, postOrderWithIdDTO.description, date);
        entityManager.persist(order);

        CreateEventDTO createEventDTO = new CreateEventDTO(postOrderWithIdDTO.id, postOrderWithIdDTO.description);
        this.createEvent.fireAsync(createEventDTO);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteOrder(Integer id) {
        Orders order = this.entityManager.getReference(Orders.class, id);
        this.entityManager.remove(order);

        String[] split = order.getShipLink().getSelf().split("/");
        Integer shipId = Integer.parseInt(split[5]);

        DeleteEventDTO deleteEventDTO = new DeleteEventDTO(shipId, order.getDescription());

        this.deleteEvent.fireAsync(deleteEventDTO);
        return true;
    }

    @Override
    @Transactional
    public boolean updateOrder(Integer id, UpdateOrderDTO updateOrderDTO) {
        Orders updateOrder = this.entityManager.find(Orders.class, id);
        updateOrder.setDescription(updateOrderDTO.description);

        String[] split = updateOrder.getShipLink().getSelf().split("/");
        Integer shipId = Integer.parseInt(split[5]);

        UpdateEventDTO updateEventDTO = new UpdateEventDTO(shipId, updateOrder.getDescription());
        this.updateEvent.fireAsync(updateEventDTO);

        return true;
    }


    @Transactional
    public void orderAccepted(@ObservesAsync ShipWithOrderIdDTO shipWithOrderIdDTO) {
        if (shipWithOrderIdDTO != null) {
            Orders order = this.entityManager.find(Orders.class, shipWithOrderIdDTO.orderId);

            order.getShipLink().setSelf(String.valueOf(shipWithOrderIdDTO.shipLink));

            System.out.println(order.getShipLink().getSelf());
        }
    }
}
