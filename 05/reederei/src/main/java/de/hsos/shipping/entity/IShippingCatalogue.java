package de.hsos.shipping.entity;


import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;

import java.util.Collection;

public interface IShippingCatalogue {

    Collection<ShipDTO> getAllShips();

    ShipDTO getShip(Integer id);

    boolean createShip(PostShipDTOWithId postShipDTO);
}
