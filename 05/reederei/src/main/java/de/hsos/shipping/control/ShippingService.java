package de.hsos.shipping.control;

import de.hsos.shipping.gateway.ShippingRepository;
import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Collection;

@ApplicationScoped
public class ShippingService implements IShippingCrud {

    @Inject
    EntityManager entityManager;


    @Inject
    ShippingRepository shippingRepository;

    // Inject the ShippingRepository with entityManager
    @Inject
    public ShippingService() {
        this.shippingRepository = new ShippingRepository(entityManager);
    }

    @Override
    public Collection<ShipDTO> getAllShips() {
        return this.shippingRepository.getAllShips();
    }

    @Override
    public ShipDTO getShip(Integer id) {
        return this.shippingRepository.getShip(id);
    }

    @Override
    public boolean createShip(PostShipDTOWithId postShipDTO) {
        return this.shippingRepository.createShip(postShipDTO);
    }
}
