package de.hsos.control.service;

import de.hsos.control.crud.ICustomersCrud;
import de.hsos.gateway.CustomerRepository;
import de.hsos.shared.dto.CustomerDTO;
import de.hsos.shared.dto.CustomerGetDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class CustomerCrudService implements ICustomersCrud {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public Collection<CustomerGetDTO> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public CustomerGetDTO getCustomer(Long id) {
        return this.customerRepository.getCustomer(id);
    }

    @Override
    public boolean createCustomer(CustomerDTO customerDTO) {
        return this.customerRepository.createCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(Long id, CustomerDTO customerDTO) {
        return this.customerRepository.updateCustomer(id, customerDTO);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return this.customerRepository.deleteCustomer(id);
    }
}
