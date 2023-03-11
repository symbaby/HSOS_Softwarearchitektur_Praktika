package de.hsos.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderingDTO {
    public List<OrderPositionDTO> orderPositionList;


    public OrderingDTO() {
    this.orderPositionList = new ArrayList<>();
    }

    public OrderingDTO(List<OrderPositionDTO> orderPositionList) {
        this.orderPositionList = orderPositionList;
    }
}
