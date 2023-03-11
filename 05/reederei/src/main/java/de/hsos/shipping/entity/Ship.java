package de.hsos.shipping.entity;

import javax.persistence.*;
import java.net.URI;


@Entity
@NamedQuery(name = "Ships.findAll", query = "SELECT s FROM Ship s ORDER BY s.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Ship implements OrderAccepted {

    @Id
    private Integer id;

    private String name;

    private boolean hasOrder;

    private URI shipLink;


    public Ship(String name) {
        this.name = name;
        this.hasOrder = false;
    }

    // For Dummy Ships
    public Ship(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.hasOrder = false;
    }

    public Ship() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHasOrder() {
        return hasOrder;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasOrder(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }

    public URI getShipLink() {
        return shipLink;
    }

    public void setShipLink(URI shipLink) {
        this.shipLink = shipLink;
    }
}
