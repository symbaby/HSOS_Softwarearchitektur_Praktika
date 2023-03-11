package de.hsos.swa.mocktail.gateway;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailDTO;
import de.hsos.swa.mocktail.entity.IMocktailCatalogue;
import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class MocktailRepository implements IMocktailCatalogue {

    private final Map<String, Mocktail> mocktails = new ConcurrentHashMap<>();

    @Override
    public boolean addMocktail(String id, String name) {
        Mocktail mocktail = new Mocktail(name, id);
        if (!mocktails.containsKey(id)) {
            mocktails.put(mocktail.getId(), mocktail);
            return true;
        }
        return false;
    }

    @Override
    public boolean addMocktail(String id, MocktailDTO mocktailDTO) {
        Mocktail mocktail = MocktailDTO.fromDTO(mocktailDTO);
        if (!mocktails.containsKey(id)) {
            mocktails.put(id, mocktail);
            return true;
        }
        return false;
    }


    @Override
    public boolean addIngredient(String id, MocktailIngredientDTO... ingredientDTOs) {

        for (MocktailIngredientDTO ingredientDTO : ingredientDTOs) {
            Ingredient ingredient = MocktailIngredientDTO.fromDTO(ingredientDTO);
            if (mocktails.containsKey(id)) {
                mocktails.get(id).addIngredient(ingredient);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteMocktail(String id) {
        if (this.mocktails.containsKey(id)) {
            this.mocktails.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteIngredient(String id, int index) {
        if (this.mocktails.containsKey(id)) {
            this.mocktails.get(id).removeIngredient(index);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Mocktail> getAllMocktails() {
        return this.mocktails.values();
    }

    // Hier Optional Typ moeglich gewesen...
    @Override
    public Mocktail getMocktail(String id) {
        if (this.mocktails.containsKey(id)) {
            return this.mocktails.get(id);
        }
        return null;
    }

    @Override
    public boolean updateMocktail(String id, String name) {

        if (this.mocktails.containsKey(id)) {
            this.mocktails.get(id).setName(name);
            return true;
        }
        return false;
    }
}
