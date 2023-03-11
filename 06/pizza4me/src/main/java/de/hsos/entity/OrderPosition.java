package de.hsos.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class OrderPosition extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "orderPositionNumber", sequenceName = "orderPositionNumber_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderPositionNumber")
    private Long id;

    @OneToOne
    private Pizza pizza;

    private int qty;

    @Version
    Long version = 0L;

    public OrderPosition() {
    
    }

    public OrderPosition(Pizza pizza, int qty) {
        this.pizza = pizza;
        this.qty = qty;
    }

    public OrderPosition(int qty) {
        this.qty = qty;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
