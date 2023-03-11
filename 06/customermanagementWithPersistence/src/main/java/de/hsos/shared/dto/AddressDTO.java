package de.hsos.shared.dto;

public class AddressDTO {
    public String postcode;
    public String location;
    public String street;
    public String number;

    public AddressDTO(){

    }

    public AddressDTO(String postcode, String location, String street, String number) {
        this.postcode = postcode;
        this.location = location;
        this.street = street;
        this.number = number;
    }
}
