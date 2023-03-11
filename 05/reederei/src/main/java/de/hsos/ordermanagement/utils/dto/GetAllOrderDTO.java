package de.hsos.ordermanagement.utils.dto;

import de.hsos.ordermanagement.acl.ShipLink;
import de.hsos.ordermanagement.entity.Orders;

import java.util.Date;

public class GetAllOrderDTO {
    public Integer id;
    public String description;
    public Date dateOfReceipt;
    public ShipLink shipLink;

    public GetAllOrderDTO(){}

    public GetAllOrderDTO(Integer id, String description, Date dateOfReceipt, ShipLink shipLink) {
        this.id = id;
        this.description = description;
        this.dateOfReceipt = dateOfReceipt;
        this.shipLink = shipLink;
    }

    public static GetAllOrderDTO toDTO(Orders order) {
        return new GetAllOrderDTO(order.getId(), order.getDescription(), order.getDateOfReceipt(), order.getShipLink());
    }

}
