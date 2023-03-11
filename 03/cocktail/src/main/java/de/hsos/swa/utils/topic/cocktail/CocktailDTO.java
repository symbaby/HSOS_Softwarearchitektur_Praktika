package de.hsos.swa.utils.topic.cocktail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CocktailDTO {

    private List<DrinkDTO> drinks = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CocktailDTO(){

    }

    public List<DrinkDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkDTO> drinks) {
        this.drinks = drinks;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}