package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.IMocktailCatalogue;
import de.hsos.swa.mocktail.entity.Mocktail;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class GetFromCatalogue {

    @Inject
    IMocktailCatalogue catalogue;

    public Collection<Mocktail> getAllMocktails() {
        return this.catalogue.getAllMocktails();
    }

    public Mocktail getMocktail(String id) {
        return this.catalogue.getMocktail(id);
    }


}
