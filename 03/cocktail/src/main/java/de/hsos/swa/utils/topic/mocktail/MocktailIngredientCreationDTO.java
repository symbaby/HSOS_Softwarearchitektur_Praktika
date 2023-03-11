package de.hsos.swa.utils.topic.mocktail;

import java.util.Objects;

public final class MocktailIngredientCreationDTO {
    private String name;
    private int quantity;

    public MocktailIngredientCreationDTO(){

    }

    public MocktailIngredientCreationDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MocktailIngredientCreationDTO that = (MocktailIngredientCreationDTO) o;
        return getQuantity() == that.getQuantity()
                && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity());
    }
}
