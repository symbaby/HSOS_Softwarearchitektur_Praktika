package de.hsos.swa.utils.topic.cocktail;

import java.util.HashMap;
import java.util.Map;

public class Ingredient {

    public String idIngredient;
    public String strIngredient;
    public String strDescription;
    public String strType;
    public String strAlcohol;
    public String strABV;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Ingredient(){

    }
}
