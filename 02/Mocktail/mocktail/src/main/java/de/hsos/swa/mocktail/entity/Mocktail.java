package de.hsos.swa.mocktail.entity;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;


/**
 * Aggregate: Verwaltung von Ingredient laeuft NUR ueber diese Klasse.
 */

public class Mocktail {
    private List<Ingredient> ingredients;
    private String name;
    private String id;

    public Mocktail(String name, String id){
        this.ingredients = new ArrayList<>();
        this.name = Objects.requireNonNull(name);
        this.id = Objects.requireNonNull(id);
    }

    public Mocktail(String name, String id, Ingredient... ingredients_) {
        this.ingredients = new ArrayList<>();
        this.ingredients.addAll(Arrays.asList(ingredients_));
        this.name = Objects.requireNonNull(name);
        this.id = Objects.requireNonNull(id);
    }

    public void removeIngredient(int index){
        this.ingredients.remove(index);
    }

    public void addIngredient(Ingredient... ingredients_) {
        this.ingredients.addAll(Arrays.asList(ingredients_));
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Mocktail other = (Mocktail) obj;
        if (ingredients == null) {
            if (other.ingredients != null)
                return false;
        } else if (!ingredients.equals(other.ingredients))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id == null) {
            return other.id == null;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mocktail [ingredients=" + ingredients + ", name=" + name + ", id=" + id + "]";
    }


}
