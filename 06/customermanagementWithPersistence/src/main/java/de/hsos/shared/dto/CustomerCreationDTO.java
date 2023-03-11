package de.hsos.shared.dto;

public class CustomerCreationDTO {
    public String firstName;
    public String lastName;

    public CustomerCreationDTO(){

    }

    public CustomerCreationDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
