package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.IMocktailCatalogue;
import de.hsos.swa.mocktail.entity.Ingredient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateInCatalogue {

    @Inject
    IMocktailCatalogue catalogue;

    public boolean addMocktail(String id, String name) {
        return this.catalogue.addMocktail(id, name);
    }

    public boolean addIngredient(String id, Ingredient... ingredients) {
        return this.catalogue.addIngredient(id, ingredients);
    }
}
