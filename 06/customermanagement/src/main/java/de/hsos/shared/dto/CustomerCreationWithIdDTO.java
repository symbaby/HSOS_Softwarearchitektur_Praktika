package de.hsos.shared.dto;

public class CustomerCreationWithIdDTO extends CustomerCreationDTO{
    public Integer id;

    public CustomerCreationWithIdDTO(String firstname, String lastname, Integer id){
        super(firstname, lastname);
        this.id = id;
    }

    public CustomerCreationWithIdDTO(){

    }
}
