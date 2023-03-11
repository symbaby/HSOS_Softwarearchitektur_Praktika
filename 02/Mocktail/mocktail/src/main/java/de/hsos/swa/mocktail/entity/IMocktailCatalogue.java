package de.hsos.swa.mocktail.entity;

import java.util.Collection;

public interface IMocktailCatalogue {

    boolean addMocktail(String id, String name);

    boolean addIngredient(String id, Ingredient... ingredients);

    boolean deleteMocktail(String id);

    boolean deleteIngredient(String id, int index);

    Collection<Mocktail> getAllMocktails();

    Mocktail getMocktail(String id);

    boolean updateMocktail(String id, String name);

}
