package de.hsos.shipping.utils.eventdto;

import de.hsos.shipping.utils.dto.ShipDTO;

import java.net.URI;

public class ShipWithOrderIdDTO extends ShipDTO {

    public Integer orderId;
    public URI shipLink;

    public ShipWithOrderIdDTO(Integer id, String name, boolean hasOrder,URI shipLink, Integer orderId){
        super(id, name, hasOrder);
        this.shipLink = shipLink;
        this.orderId = orderId;
    }
}
