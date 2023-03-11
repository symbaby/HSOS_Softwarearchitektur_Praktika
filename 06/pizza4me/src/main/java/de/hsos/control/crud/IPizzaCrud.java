package de.hsos.control.crud;

import de.hsos.shared.dto.OrderingDTO;
import de.hsos.shared.dto.OrderingGetDTO;
import de.hsos.shared.dto.PizzaDTO;

import java.util.Collection;

public interface IPizzaCrud {

    Collection<PizzaDTO> getAllPizza();

    PizzaDTO getPizza(Long id);

    boolean createPizza();

}
