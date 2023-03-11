package de.hsos.swa.utils.topic.mocktail;

import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MocktailDTO {
    public List<Ingredient> ingredients;
    public String name;
    public String id;

    public MocktailDTO() {

    }
    public MocktailDTO(String name, String id) {
        this.ingredients = new ArrayList<>();
        this.name = Objects.requireNonNull(name);
        this.id = Objects.requireNonNull(id);
    }

    public MocktailDTO(String name, String id, List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.name = Objects.requireNonNull(name);
        this.id = Objects.requireNonNull(id);
    }

    public static MocktailDTO toDTO(Mocktail mocktail) {
        return new MocktailDTO(mocktail.getId(), mocktail.getName(), (List<Ingredient>) mocktail.getIngredients());
    }

    public static Mocktail fromDTO(MocktailDTO mocktailDTO) {
        return new Mocktail(mocktailDTO.id, mocktailDTO.name, mocktailDTO.ingredients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MocktailDTO that = (MocktailDTO) o;
        return Objects.equals(ingredients, that.ingredients) &&
                Objects.equals(name, that.name) &&
                Objects.equals(id, that.id);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, name, id);
    }
}
