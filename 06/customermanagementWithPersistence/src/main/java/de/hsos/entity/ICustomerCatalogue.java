package de.hsos.entity;

import de.hsos.shared.dto.AddressDTO;
import de.hsos.shared.dto.CustomerCreationDTO;
import de.hsos.shared.dto.CustomerCreationWithIdDTO;
import de.hsos.shared.dto.CustomerDTO;

import java.util.Collection;

public interface ICustomerCatalogue {

    boolean createCustomer(CustomerCreationWithIdDTO creationWithIdDTO);

    Collection<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Integer id);

    boolean deleteCustomerById(Integer id);

    boolean createAddressForCustomerById(Integer id, AddressDTO addressDTO);

    boolean updateAddressFromCustomerById(Integer id, AddressDTO addressDTO);

    AddressDTO getAddressFromCustomerById(Integer id);

    boolean deleteAddressFromCustomerById(Integer id);

}
