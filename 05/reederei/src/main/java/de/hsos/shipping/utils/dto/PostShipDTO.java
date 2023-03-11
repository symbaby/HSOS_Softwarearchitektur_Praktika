package de.hsos.shipping.utils.dto;


import de.hsos.shipping.entity.Ship;

public class PostShipDTO {
    public String name;

    public PostShipDTO() {
    }

    public PostShipDTO(String name) {
        this.name = name;
    }

    public static Ship fromDTO(PostShipDTO postShipDTO) {
        return new Ship(postShipDTO.name);
    }

}
