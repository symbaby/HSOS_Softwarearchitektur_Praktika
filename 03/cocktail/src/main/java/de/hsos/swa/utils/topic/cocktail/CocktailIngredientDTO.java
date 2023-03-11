package de.hsos.swa.utils.topic.cocktail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CocktailIngredientDTO {

    private List<Ingredient> ingredients = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CocktailIngredientDTO(){

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }




}
