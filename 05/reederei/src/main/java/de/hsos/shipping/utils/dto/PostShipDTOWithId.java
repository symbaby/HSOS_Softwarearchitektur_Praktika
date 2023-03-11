package de.hsos.shipping.utils.dto;

import de.hsos.shipping.entity.Ship;

import java.net.URI;


public class PostShipDTOWithId extends PostShipDTO {
    public Integer id;

    public URI shipLink;

    public PostShipDTOWithId() {

    }

    public PostShipDTOWithId(Integer id, String name) {
        super(name);
        this.id = id;
    }


    public static Ship fromDTO(PostShipDTOWithId postShipDTOWithId) {
        Ship s = new Ship(postShipDTOWithId.id, postShipDTOWithId.name);

        if(postShipDTOWithId.shipLink != null){
            s.setShipLink(postShipDTOWithId.shipLink);
        }

        return s;
    }


    @Override
    public String toString() {
        return "PostShipDTOWithId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
