package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.Mocktail;

import java.util.Collection;

public interface IGetMocktail {

    Collection<Mocktail> getAllMocktails();

    Mocktail getMocktail(String id);

}
