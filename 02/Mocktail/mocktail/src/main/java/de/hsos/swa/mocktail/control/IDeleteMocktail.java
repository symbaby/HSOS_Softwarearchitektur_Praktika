package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.Mocktail;

public interface IDeleteMocktail {

    boolean deleteMocktail(String id);

    boolean deleteIngredient(String id, int index);

}
