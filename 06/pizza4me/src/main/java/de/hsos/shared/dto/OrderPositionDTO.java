package de.hsos.shared.dto;

public class OrderPositionDTO {
    public long pizzaId;
    public int quantity;
    public String pizzaName;

    public OrderPositionDTO(long pizzaId, int quantity, String pizzaName) {
        this.pizzaId = pizzaId;
        this.quantity = quantity;
        this.pizzaName = pizzaName;
    }

    public OrderPositionDTO(){

    }
}
