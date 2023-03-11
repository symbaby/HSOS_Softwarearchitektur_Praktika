package de.hsos.control;

import de.hsos.shared.dto.AddressDTO;
import de.hsos.shared.dto.CustomerCreationDTO;
import de.hsos.shared.dto.CustomerCreationWithIdDTO;
import de.hsos.shared.dto.CustomerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class CustomerManagement implements ICustomerCrud {

    @Inject
    CustomerService customerService;

    @Override
    public boolean createCustomer(CustomerCreationWithIdDTO creationWithIdDTO) {
        return this.customerService.createCustomer(creationWithIdDTO);
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {

        return this.customerService.getAllCustomers();
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        return this.customerService.getCustomerById(id);
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        return this.customerService.deleteCustomerById(id);
    }

    @Override
    public boolean createAddressForCustomerById(Integer id, AddressDTO addressDTO) {

        return this.customerService.createAddressForCustomerById(id, addressDTO);
    }

    @Override
    public boolean updateAddressFromCustomerById(Integer id, AddressDTO addressDTO) {
        return this.customerService.updateAddressFromCustomerById(id,addressDTO);
    }

    @Override
    public AddressDTO getAddressFromCustomerById(Integer id) {
        return this.customerService.getAddressFromCustomerById(id);
    }

    @Override
    public boolean deleteAddressFromCustomerById(Integer id) {
        return this.customerService.deleteAddressFromCustomerById(id);
    }
}
