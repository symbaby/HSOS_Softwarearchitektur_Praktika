package de.hsos.ordermanagement.utils.eventdto;

public class DeleteEventDTO {

    public Integer id;
    public String description;



    public DeleteEventDTO(){

    }

    public DeleteEventDTO(Integer id, String description){
        this.id = id;
        this.description = description;
    }
}
