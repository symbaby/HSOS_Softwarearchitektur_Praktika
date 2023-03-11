package de.hsos.gateway;

import de.hsos.entity.Address;
import de.hsos.entity.Customer;
import de.hsos.entity.ICustomerCatalogue;
import de.hsos.shared.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class CustomerRepository implements ICustomerCatalogue {

    private Map<Integer, Customer> customerMap = new ConcurrentHashMap<>();

    public CustomerRepository() {
        // Insert Dummy Data...
        Customer c1 = new Customer(100, "Berkan", "Yildiz",
                new Address("32257", "Buende", "Neustadt", "32")
        );

        Customer c2 = new Customer(101, "Sam", "Fischer",
                new Address("32278", "Kirchlengern", "Weststrasse", "1")
        );

        this.customerMap.put(c1.getId(), c1);
        this.customerMap.put(c2.getId(), c2);
    }

    @Override
    public boolean createCustomer(CustomerCreationWithIdDTO creationWithIdDTO) {
        // Wir brauchen eine ID Generator...

        Customer customer = DTOConverter.fromCustomerCreationDTO(creationWithIdDTO);

        System.out.println(customer.getId() + " ist die ID");

        if (!this.customerMap.containsKey(customer.getId())) {
            this.customerMap.put(customer.getId(), customer);
            return true;
        }

        return false;
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {

        Map<Integer, CustomerDTO> customerDTOMap = new HashMap<>();
        for (Customer customer : customerMap.values()) {
            customerDTOMap.put(customer.getId(), DTOConverter.toCustomerDTO(customer));
        }
        return customerDTOMap.values();

    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        // CustomerDTO customerDTO = DTOConverter.toCustomerDTO(this.customerMap.get(id));
        if (this.customerMap.containsKey(id)) {
            return DTOConverter.toCustomerDTO(this.customerMap.get(id));
        }
        return null;
    }

    @Override
    public boolean deleteCustomerById(Integer id) {

        if (this.customerMap.containsKey(id)) {
            this.customerMap.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean createAddressForCustomerById(Integer id, AddressDTO addressDTO) {

        if (!this.customerMap.containsKey(id)) {
            return false;
        }

        Address address = DTOConverter.fromAddressDTO(addressDTO);
        this.customerMap.get(id).setAddress(address);
        return true;

    }

    @Override
    public boolean updateAddressFromCustomerById(Integer id, AddressDTO addressDTO) {

        if (this.customerMap.containsKey(id)) {
            Customer customer = this.customerMap.get(id);
            Address address = new Address(addressDTO.postcode, addressDTO.location, addressDTO.street, addressDTO.number);
            customer.setAddress(address);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AddressDTO getAddressFromCustomerById(Integer id) {

        if (!this.customerMap.containsKey(id)) {
            return null;
        }

        return DTOConverter.toAddressDTO(this.customerMap.get(id).getAddress());


    }

    @Override
    public boolean deleteAddressFromCustomerById(Integer id) {

        if (this.customerMap.containsKey(id)) {
            Customer customer = this.customerMap.get(id);
            Address address = new Address();
            customer.setAddress(address);
            return true;
        } else {
            return false;
        }
    }

}
