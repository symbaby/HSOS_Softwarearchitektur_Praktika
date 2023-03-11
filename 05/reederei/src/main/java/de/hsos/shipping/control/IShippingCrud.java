package de.hsos.shipping.control;

import de.hsos.shipping.utils.dto.PostShipDTO;
import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;

import javax.persistence.EntityManager;
import java.util.Collection;

public interface IShippingCrud {

    Collection<ShipDTO> getAllShips();

    ShipDTO getShip(Integer id);

    boolean createShip(PostShipDTOWithId postShipDTO);
}
