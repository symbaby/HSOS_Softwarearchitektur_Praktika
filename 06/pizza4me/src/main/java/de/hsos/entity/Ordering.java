package de.hsos.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ordering {

    @Id
    @SequenceGenerator(name = "orderingNumber", sequenceName = "orderingNumber_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderingNumber")
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<OrderPosition> orderPositionList;

    @Version
    Long version = 0L;

    public Ordering() {
        this.orderPositionList = new ArrayList<>();
    }

    public Ordering(List<OrderPosition> orderPositionList) {
        this.orderPositionList = orderPositionList;
    }


    public Long getId() {
        return id;
    }

    public List<OrderPosition> getOrderPositionList() {
        return this.orderPositionList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderPositionList(List<OrderPosition> orderPositionList) {
        this.orderPositionList = orderPositionList;
    }
}
