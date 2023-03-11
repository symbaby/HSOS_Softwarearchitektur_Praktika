package de.hsos.shared.dto;

import de.hsos.entity.Address;

public class CustomerDTO {

    public String name;
    public Address address;

    public CustomerDTO(){}

    public CustomerDTO(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
