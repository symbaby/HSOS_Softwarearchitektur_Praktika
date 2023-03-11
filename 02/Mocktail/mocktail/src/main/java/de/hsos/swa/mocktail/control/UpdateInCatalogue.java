package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.IMocktailCatalogue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateInCatalogue {

    @Inject
    IMocktailCatalogue catalogue;


    public boolean updateMocktail(String id, String name) {
        return this.catalogue.updateMocktail(id, name);
    }

}
