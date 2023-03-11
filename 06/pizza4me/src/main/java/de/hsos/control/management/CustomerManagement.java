package de.hsos.control.management;

import de.hsos.control.crud.ICustomersCrud;
import de.hsos.control.service.CustomerCrudService;
import de.hsos.shared.dto.CustomerDTO;
import de.hsos.shared.dto.CustomerGetDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class CustomerManagement implements ICustomersCrud {

    @Inject
    CustomerCrudService customerCrudService;

    @Override
    public Collection<CustomerGetDTO> getAllCustomers() {
        return this.customerCrudService.getAllCustomers();
    }

    @Override
    public CustomerGetDTO getCustomer(Long id) {
        return this.customerCrudService.getCustomer(id);
    }

    @Override
    public boolean createCustomer(CustomerDTO customerDTO) {
        return this.customerCrudService.createCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(Long id, CustomerDTO customerDTO) {
        return this.customerCrudService.updateCustomer(id, customerDTO);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return this.customerCrudService.deleteCustomer(id);
    }
}
