package de.hsos.swa.mocktail.entity;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailDTO;

import java.util.Collection;

public interface IMocktailCatalogue {

    boolean addMocktail(String id, String name);

    boolean addMocktail(String id, MocktailDTO mocktailDTO);

    boolean addIngredient(String id, MocktailIngredientDTO... ingredientDTOs);

    boolean deleteMocktail(String id);

    boolean deleteIngredient(String id, int index);

    Collection<Mocktail> getAllMocktails();

    Mocktail getMocktail(String id);

    boolean updateMocktail(String id, String name);

}
