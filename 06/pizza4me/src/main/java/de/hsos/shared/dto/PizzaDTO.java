package de.hsos.shared.dto;

public class PizzaDTO {
    public long pizzaId;
    public String name;
    public double price;



    public PizzaDTO(long pizzaId, String name, double price) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.price = price;
    }

    public PizzaDTO(){

    }
}
