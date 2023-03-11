package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class MocktailManagement implements IGetMocktail, ICreateMocktail, IUpdateMocktail, IDeleteMocktail {

    // Inject here
    @Inject
    GetFromCatalogue getFromCatalogue;

    @Inject
    CreateInCatalogue createInCatalogue;

    @Inject
    UpdateInCatalogue updateInCatalogue;

    @Inject
    DeleteFromCatalogue deleteFromCatalogue;


    @Override
    public boolean addMocktail(String id, String name) {
        return this.createInCatalogue.addMocktail(id, name);
    }

    @Override
    public boolean addIngredient(String id, Ingredient... ingredients) {
        return this.createInCatalogue.addIngredient(id, ingredients);
    }

    @Override
    public boolean deleteMocktail(String id) {
        return this.deleteFromCatalogue.deleteMocktail(id);
    }

    @Override
    public boolean deleteIngredient(String id, int index) {
        return this.deleteFromCatalogue.deleteIngredient(id, index);
    }

    @Override
    public Collection<Mocktail> getAllMocktails() {
        return this.getFromCatalogue.getAllMocktails();
    }

    @Override
    public Mocktail getMocktail(String id) {
        return this.getFromCatalogue.getMocktail(id);
    }

    @Override
    public boolean updateMocktail(String id, String name) {
        return this.updateInCatalogue.updateMocktail(id, name);
    }

}
