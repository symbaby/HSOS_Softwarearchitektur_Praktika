package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;

public interface ICreateMocktail {
    boolean addMocktail(String id, String name);
    boolean addIngredient(String id, Ingredient... ingredients);
}
