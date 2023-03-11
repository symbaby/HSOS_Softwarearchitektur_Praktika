package de.hsos.shared.dto;

import de.hsos.entity.Address;
import de.hsos.entity.Customer;

public class DTOConverter {
    // all to-from Methods here...

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getFirstname(), customer.getLastname(), DTOConverter.toAddressDTO(customer.getAddress()));
    }

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(address.getPostcode(), address.getLocation(), address.getStreet(), address.getNumber());
    }

    public static Customer fromCustomerCreationDTO(CustomerCreationWithIdDTO creationWithIdDTO) {
        return new Customer(creationWithIdDTO.id, creationWithIdDTO.firstName, creationWithIdDTO.lastName);
    }

    public static Address fromAddressDTO(AddressDTO addressDTO) {
        return new Address(addressDTO.postcode, addressDTO.location, addressDTO.street, addressDTO.number);
    }
}
