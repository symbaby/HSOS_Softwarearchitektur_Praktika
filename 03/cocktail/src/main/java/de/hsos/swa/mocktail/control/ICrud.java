package de.hsos.swa.mocktail.control;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailDTO;
import de.hsos.swa.mocktail.entity.Mocktail;

import java.util.Collection;

public interface ICrud {
    boolean addMocktail(String id, String name);

    boolean addMocktail(String id, MocktailDTO mocktailDTO);

    boolean addIngredient(String id, MocktailIngredientDTO... ingredientsDTOs);

    boolean deleteMocktail(String id);

    boolean deleteIngredient(String id, int index);

    Collection<Mocktail> getAllMocktails();

    Mocktail getMocktail(String id);

    boolean updateMocktail(String id, String name);
}
