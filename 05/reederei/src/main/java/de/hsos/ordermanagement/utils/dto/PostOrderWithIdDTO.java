package de.hsos.ordermanagement.utils.dto;

public class PostOrderWithIdDTO extends PostOrderDTO{

    public Integer id;

    public PostOrderWithIdDTO(){}
    public PostOrderWithIdDTO(String description, Integer id){
        super(description);
        this.id = id;
    }

}
