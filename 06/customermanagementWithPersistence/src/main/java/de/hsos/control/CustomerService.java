package de.hsos.control;

import de.hsos.entity.Customer;
import de.hsos.gateway.CustomerRepository;
import de.hsos.shared.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequestScoped
public class CustomerService implements ICustomerCrud {


    @Inject
    CustomerRepository customerRepository;


    @Override
    public boolean createCustomer(CustomerCreationWithIdDTO creationWithIdDTO) {
        return this.customerRepository.createCustomer(creationWithIdDTO);
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {

        return this.customerRepository.getAllCustomers();

    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        return this.customerRepository.getCustomerById(id);
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        return this.customerRepository.deleteCustomerById(id);
    }

    @Override
    public boolean createAddressForCustomerById(Integer id, AddressDTO addressDTO) {
        return this.customerRepository.createAddressForCustomerById(id, addressDTO);
    }

    @Override
    public boolean updateAddressFromCustomerById(Integer id, AddressDTO addressDTO) {
        return this.customerRepository.updateAddressFromCustomerById(id, addressDTO);
    }

    @Override
    public AddressDTO getAddressFromCustomerById(Integer id) {
        return this.customerRepository.getAddressFromCustomerById(id);
    }

    @Override
    public boolean deleteAddressFromCustomerById(Integer id) {
        return this.customerRepository.deleteAddressFromCustomerById(id);
    }
}
