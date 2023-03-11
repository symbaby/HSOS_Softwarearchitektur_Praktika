package de.hsos.swa.mocktail.control;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailDTO;
import de.hsos.swa.mocktail.entity.Mocktail;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class MocktailManagement implements ICrud {

    @Inject
    CrudImpl crud;

    @Override
    public boolean addMocktail(String id, String name) {
        return this.crud.addMocktail(id, name);
    }


    @Override
    public boolean addMocktail(String id, MocktailDTO mocktailDTO) {
        return this.crud.addMocktail(id, mocktailDTO);
    }


    @Override
    public boolean addIngredient(String id, MocktailIngredientDTO... ingredientDTOs) {
        return this.crud.addIngredient(id, ingredientDTOs);
    }

    @Override
    public boolean deleteMocktail(String id) {
        return this.crud.deleteMocktail(id);
    }


    @Override
    public boolean deleteIngredient(String id, int index) {
        return this.crud.deleteIngredient(id, index);
    }

    @CircuitBreaker(requestVolumeThreshold = 4)
    @Override
    public Collection<Mocktail> getAllMocktails() {
        return this.crud.getAllMocktails();
    }

    @CircuitBreaker(requestVolumeThreshold = 4)
    @Override
    public Mocktail getMocktail(String id) {
        return this.crud.getMocktail(id);
    }


    @Override
    public boolean updateMocktail(String id, String name) {
        return this.crud.updateMocktail(id, name);
    }

}
