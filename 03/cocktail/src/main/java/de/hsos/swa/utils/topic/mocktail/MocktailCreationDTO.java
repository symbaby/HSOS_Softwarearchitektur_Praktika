package de.hsos.swa.utils.topic.mocktail;

import java.util.List;
import java.util.Objects;

public final class MocktailCreationDTO {
    private String id;
    private String name;
    private List<MocktailIngredientDTO> ingredients;

    public MocktailCreationDTO() {

    }

    public MocktailCreationDTO(String id, String name, List<MocktailIngredientDTO> ingredients) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.ingredients = Objects.requireNonNull(ingredients);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MocktailIngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<MocktailIngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MocktailCreationDTO that = (MocktailCreationDTO) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getIngredients(), that.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIngredients());
    }
}
