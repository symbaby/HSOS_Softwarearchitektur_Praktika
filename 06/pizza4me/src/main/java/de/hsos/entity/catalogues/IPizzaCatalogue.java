package de.hsos.entity.catalogues;

import de.hsos.shared.dto.PizzaDTO;

import java.util.Collection;

public interface IPizzaCatalogue {

    Collection<PizzaDTO> getAllPizza();

    PizzaDTO getPizza(Long id);

    boolean createPizza();

}
