package de.hsos.shared.dto;

import de.hsos.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class CustomerGetDTO {

    public long id;
    public String name;
    public Address address;

    public OrderingGetDTO currentOrderDTO;

    public CustomerGetDTO() {
        this.currentOrderDTO = new OrderingGetDTO();
    }

    public CustomerGetDTO(String name, Address address, OrderingGetDTO currentOrderDTO, Long id) {
        this.name = name;
        this.address = address;
        this.currentOrderDTO = currentOrderDTO;
        this.id = id;
    }
}
