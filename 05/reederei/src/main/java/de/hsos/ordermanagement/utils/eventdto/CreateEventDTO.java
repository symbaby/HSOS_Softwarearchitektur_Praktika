package de.hsos.ordermanagement.utils.eventdto;

public class CreateEventDTO {

    public Integer id;
    public String description;

    public CreateEventDTO(){}

    public CreateEventDTO(Integer id, String description){
        this.description = description;
        this.id = id;
    }
}
