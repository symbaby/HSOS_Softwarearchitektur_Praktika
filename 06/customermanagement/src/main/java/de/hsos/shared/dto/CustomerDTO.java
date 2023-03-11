package de.hsos.shared.dto;

public class CustomerDTO {
    public String firstName;
    public String lastName;
    public AddressDTO address;

    public CustomerDTO(){

    }

    public CustomerDTO(String firstName, String lastName, AddressDTO addressDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = addressDTO;
    }
}
