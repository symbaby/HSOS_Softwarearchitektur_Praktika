package de.hsos.ordermanagement.utils.eventdto;

public class UpdateEventDTO {

    public Integer id;
    public String description;

    public UpdateEventDTO(){

    }

    public UpdateEventDTO(Integer id, String description){
        this.id = id;
        this.description = description;
    }
}
