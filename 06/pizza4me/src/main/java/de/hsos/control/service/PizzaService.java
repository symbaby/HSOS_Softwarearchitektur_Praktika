package de.hsos.control.service;

import de.hsos.boundary.resource.PizzaResource;
import de.hsos.control.crud.IPizzaCrud;
import de.hsos.gateway.PizzaRepository;
import de.hsos.shared.dto.PizzaDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class PizzaService implements IPizzaCrud {

    @Inject
    PizzaRepository pizzaRepository;

    @Override
    public Collection<PizzaDTO> getAllPizza() {
        return this.pizzaRepository.getAllPizza();
    }

    @Override
    public PizzaDTO getPizza(Long id) {
        return this.pizzaRepository.getPizza(id);
    }

    @Override
    public boolean createPizza() {
        return this.pizzaRepository.createPizza();
    }
}
