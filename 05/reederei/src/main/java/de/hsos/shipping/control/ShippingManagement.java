package de.hsos.shipping.control;

import de.hsos.shipping.utils.dto.PostShipDTO;
import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ShippingManagement implements IShippingCrud{

    @Inject
    ShippingService shippingService;

    @Override
    public Collection<ShipDTO> getAllShips() {
        return this.shippingService.getAllShips();
    }

    @Override
    public ShipDTO getShip(Integer id) {
        return this.shippingService.getShip(id);
    }

    @Override
    public boolean createShip(PostShipDTOWithId postShipDTO) {
        return this.shippingService.createShip(postShipDTO);
    }
}
