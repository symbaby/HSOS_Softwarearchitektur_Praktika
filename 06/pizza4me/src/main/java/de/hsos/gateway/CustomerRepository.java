package de.hsos.gateway;

import de.hsos.entity.Customer;
import de.hsos.entity.Ordering;
import de.hsos.entity.UserLogin;
import de.hsos.entity.catalogues.ICustomerCatalogue;
import de.hsos.shared.dto.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RequestScoped
@Transactional
public class CustomerRepository implements ICustomerCatalogue, PanacheRepository<Customer> {

    @Transactional
    public void loadUsers(@Observes StartupEvent event) {
        UserLogin.deleteAll();
        UserLogin.add("admin", "admin", "admin");
        UserLogin.add("user", "user", "user");
    }

    @Override
    public Collection<CustomerGetDTO> getAllCustomers() {

        Collection<Customer> customerList = listAll();
        Collection<CustomerGetDTO> dtoList = new ArrayList<>();

        for (Customer c : customerList) {
            dtoList.add(DTOConverter.toCustomerGetDTO(c));
        }
        return dtoList;
    }


    @Override
    public CustomerGetDTO getCustomer(Long id) {

        return DTOConverter.toCustomerGetDTO(Customer.findById(id));
    }


    /*
    @Override
    public CustomerGetDTO getCustomer(Long id) {
        Customer c = findById(id);

        List<OrderingGetDTO> dtoList = new ArrayList<>();

        for(Ordering o : c.getOrderingList()){
            dtoList.add(DTOConverter.toOrderingGetDTO(o));
        }

        return new CustomerGetDTO(c.getName(), c.getAddress(),dtoList);
    }
    */


    @Override
    public boolean createCustomer(CustomerDTO customerDTO) {
        if (customerDTO != null) {
            Customer c = DTOConverter.fromCustomerDTO(customerDTO);
            persist(c);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Long id, CustomerDTO customerDTO) {

        if (customerDTO != null) {
            Customer c = findById(id);
            c.setName(customerDTO.name);
            c.setAddress(customerDTO.address);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {

        return deleteById(id);
    }
}

