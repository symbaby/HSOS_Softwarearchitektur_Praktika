package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.IMocktailCatalogue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteFromCatalogue {

    @Inject
    IMocktailCatalogue catalogue;

    public boolean deleteMocktail(String id) {
        return this.catalogue.deleteMocktail(id);
    }

    public boolean deleteIngredient(String id, int index) {
        return this.catalogue.deleteIngredient(id, index);
    }
}
