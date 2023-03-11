package de.hsos.entity.catalogues;

import de.hsos.shared.dto.CustomerDTO;
import de.hsos.shared.dto.CustomerGetDTO;

import java.util.Collection;

public interface ICustomerCatalogue {

    Collection<CustomerGetDTO> getAllCustomers();

    CustomerGetDTO getCustomer(Long id);

    boolean createCustomer(CustomerDTO customerDTO);

    boolean updateCustomer(Long id, CustomerDTO customerDTO);

    boolean deleteCustomer(Long id);

}
