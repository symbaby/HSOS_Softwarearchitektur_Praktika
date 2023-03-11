package de.hsos.ordermanagement.entity;

import de.hsos.ordermanagement.acl.ShipLink;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o ORDER BY o.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Orders implements CreateEvent{
    @Id
    private Integer id;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReceipt;

    @Embedded
    private ShipLink shipLink;

    public Orders(){}

    public Orders(Integer id, String description, Date dateOfReceipt) {
        this.id = id;
        this.description = description;
        this.dateOfReceipt = dateOfReceipt;
        this.shipLink = new ShipLink();
    }

    public Orders(Integer id, String description, Date dateOfReceipt, ShipLink shipLink) {
        this.id = id;
        this.description = description;
        this.dateOfReceipt = dateOfReceipt;
        this.shipLink = shipLink;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public ShipLink getShipLink() {
        return shipLink;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public void setShipLink(ShipLink shipLink) {
        this.shipLink = shipLink;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateOfReceipt=" + dateOfReceipt +
                ", shipLink=" + shipLink +
                '}';
    }
}
