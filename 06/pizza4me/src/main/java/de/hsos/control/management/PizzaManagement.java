package de.hsos.control.management;

import de.hsos.control.crud.IPizzaCrud;
import de.hsos.control.service.PizzaService;
import de.hsos.shared.dto.PizzaDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class PizzaManagement implements IPizzaCrud {

    @Inject
    PizzaService pizzaService;

    @Override
    public Collection<PizzaDTO> getAllPizza() {
        return this.pizzaService.getAllPizza();
    }

    @Override
    public PizzaDTO getPizza(Long id) {
        return this.pizzaService.getPizza(id);
    }

    @Override
    public boolean createPizza() {
        return this.pizzaService.createPizza();
    }
}
