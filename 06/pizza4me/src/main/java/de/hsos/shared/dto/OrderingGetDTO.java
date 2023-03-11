package de.hsos.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderingGetDTO {
    public List<OrderPositionDTO> orderPositionDTOs;

    public OrderingGetDTO(List<OrderPositionDTO> orderPositionDTOs) {
        this.orderPositionDTOs = orderPositionDTOs;
    }

    public OrderingGetDTO() {
        this.orderPositionDTOs = new ArrayList<>();
    }
}
