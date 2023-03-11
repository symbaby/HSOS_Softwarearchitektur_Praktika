package de.hsos.gateway;

import de.hsos.entity.Pizza;
import de.hsos.entity.catalogues.IPizzaCatalogue;
import de.hsos.shared.dto.PizzaDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class PizzaRepository implements IPizzaCatalogue, PanacheRepository<Pizza> {

    @Override
    @Transactional
    public Collection<PizzaDTO> getAllPizza() {
        listAll();
        Collection<PizzaDTO> pizzaDTOList = new ArrayList<>();

        for (Pizza pizza : listAll()) {
            pizzaDTOList.add(new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice()));
        }
        return pizzaDTOList;
    }

    @Override
    @Transactional
    public PizzaDTO getPizza(Long id) {
        Pizza p = findById(id);
        return new PizzaDTO(p.getId(), p.getName(), p.getPrice());
    }

    @Override
    @Transactional
    public boolean createPizza() {

        Pizza p1 = new Pizza("Affen-Pizza", 10.0);
        Pizza p2 = new Pizza("Thunfisch-Pizza", 8.0);
        Pizza p3 = new Pizza("Mett-Pizza", 2.0);
        Pizza p4 = new Pizza("Schweinewurst-Pizza", 7.0);

        persist(p1, p2, p3, p4);

        System.out.println(p1.getId());
        System.out.println(p2.getId());
        System.out.println(p3.getId());
        System.out.println(p4.getId());


        return true;
    }


}
