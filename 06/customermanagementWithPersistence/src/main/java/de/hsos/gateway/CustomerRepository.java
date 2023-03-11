package de.hsos.gateway;

import de.hsos.entity.Address;
import de.hsos.entity.Customer;
import de.hsos.entity.ICustomerCatalogue;
import de.hsos.shared.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;


@RequestScoped
public class CustomerRepository implements ICustomerCatalogue {

    @Inject
    EntityManager entityManager;


    @Override
    @Transactional
    public boolean createCustomer(CustomerCreationWithIdDTO creationWithIdDTO) {
        Customer customer = DTOConverter.fromCustomerCreationDTO(creationWithIdDTO);
        entityManager.persist(customer);

        return true;
    }

    @Override
    @Transactional
    public Collection<CustomerDTO> getAllCustomers() {

        Collection<Customer> o = entityManager.createNamedQuery("Customers.findAll", Customer.class).getResultList();
        List<CustomerDTO> dtoList = new ArrayList<>();

        for (Customer customer : o) {
            dtoList.add(DTOConverter.toCustomerDTO(customer));
        }

        return dtoList;
    }

    @Override
    @Transactional
    public CustomerDTO getCustomerById(Integer id) {
        Customer customer = this.entityManager.find(Customer.class, id);

        if (customer == null) {
            return null;
        } else {
            return DTOConverter.toCustomerDTO(customer);
        }
    }

    @Override
    @Transactional
    public boolean deleteCustomerById(Integer id) {

        Customer customer = this.entityManager.getReference(Customer.class, id);
        this.entityManager.remove(customer);

        return true;
    }

    @Override
    @Transactional
    public boolean createAddressForCustomerById(Integer id, AddressDTO addressDTO) {

        Customer customer = this.entityManager.find(Customer.class, id);

        if (customer == null) {
            return false;
        } else {
            Address address = DTOConverter.fromAddressDTO(addressDTO);
            customer.setAddress(address);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean updateAddressFromCustomerById(Integer id, AddressDTO addressDTO) {

        Customer customer = this.entityManager.find(Customer.class, id);

        if (customer == null) {
            return false;
        } else {
            Address address = DTOConverter.fromAddressDTO(addressDTO);
            customer.setAddress(address);
            return true;
        }

        /*

        if (this.customerMap.containsKey(id)) {
            Customer customer = this.customerMap.get(id);
            Address address = new Address(addressDTO.postcode, addressDTO.location, addressDTO.street, addressDTO.number);
            customer.setAddress(address);
            return true;
        } else {
            return false;
        }

         */
    }

    @Override
    @Transactional
    public AddressDTO getAddressFromCustomerById(Integer id) {

        Customer customer = this.entityManager.find(Customer.class, id);

        if (customer == null) {
            return null;
        } else {
            return DTOConverter.toAddressDTO(this.entityManager.find(Customer.class, id).getAddress());
        }
    }

    @Override
    @Transactional
    public boolean deleteAddressFromCustomerById(Integer id) {

        Customer customer = this.entityManager.find(Customer.class, id);

        if (customer == null) {
            return false;
        } else {
            Address address = new Address();
            customer.setAddress(address);
            return true;
        }
    }
}
