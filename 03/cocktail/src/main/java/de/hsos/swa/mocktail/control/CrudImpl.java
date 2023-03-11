package de.hsos.swa.mocktail.control;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailDTO;
import de.hsos.swa.mocktail.entity.IMocktailCatalogue;
import de.hsos.swa.mocktail.entity.Mocktail;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class CrudImpl implements ICrud {

    @Inject
    IMocktailCatalogue catalogue;

    @Override
    public boolean addMocktail(String id, String name) {
        return this.catalogue.addMocktail(id, name);
    }

    @Override
    public boolean addMocktail(String id, MocktailDTO mocktailDTO) {
        return this.catalogue.addMocktail(id, mocktailDTO);
    }

    @Override
    public boolean addIngredient(String id, MocktailIngredientDTO... ingredientsDTOs) {
        return this.catalogue.addIngredient(id, ingredientsDTOs);
    }

    @Override
    public boolean deleteMocktail(String id) {
        return this.catalogue.deleteMocktail(id);
    }

    @Override
    public boolean deleteIngredient(String id, int index) {
        return this.catalogue.deleteIngredient(id, index);
    }

    @Override
    public Collection<Mocktail> getAllMocktails() {
        return this.catalogue.getAllMocktails();
    }

    @Override
    public Mocktail getMocktail(String id) {
        return this.catalogue.getMocktail(id);
    }

    @Override
    public boolean updateMocktail(String id, String name) {
        return this.catalogue.updateMocktail(id, name);
    }
}
