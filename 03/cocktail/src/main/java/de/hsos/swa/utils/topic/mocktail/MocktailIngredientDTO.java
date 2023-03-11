package de.hsos.swa.utils.topic.mocktail;

import de.hsos.swa.mocktail.entity.Ingredient;

import java.util.Objects;

public class MocktailIngredientDTO {
    public String name;
    public int quantity;

    public MocktailIngredientDTO() {

    }

    public MocktailIngredientDTO(String name, int quantity) {
        this.name = Objects.requireNonNull(name);
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static MocktailIngredientDTO toDTO(Ingredient ingredient) {
        return new MocktailIngredientDTO(ingredient.getName(), ingredient.getQuantity());
    }

    public static Ingredient fromDTO(MocktailIngredientDTO ingredientDTO) {
        return new Ingredient(ingredientDTO.name, ingredientDTO.quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MocktailIngredientDTO that = (MocktailIngredientDTO) o;
        return getQuantity() == that.getQuantity() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity());
    }
}
