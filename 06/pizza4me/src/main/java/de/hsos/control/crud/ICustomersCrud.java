package de.hsos.control.crud;

import de.hsos.shared.dto.CustomerDTO;
import de.hsos.shared.dto.CustomerGetDTO;

import java.util.Collection;

public interface ICustomersCrud {

     Collection<CustomerGetDTO> getAllCustomers();

     CustomerGetDTO getCustomer(Long id);

     boolean createCustomer(CustomerDTO customerDTO);

     boolean updateCustomer(Long id, CustomerDTO customerDTO);

     boolean deleteCustomer(Long id);
}
