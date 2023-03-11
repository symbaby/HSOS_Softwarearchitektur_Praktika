package de.hsos.boundary.rest;

import de.hsos.control.CustomerManagement;
import de.hsos.shared.dto.AddressDTO;
import de.hsos.shared.dto.CustomerCreationDTO;
import de.hsos.shared.dto.CustomerCreationWithIdDTO;
import de.hsos.shared.dto.CustomerDTO;
import de.hsos.shared.id.CustomerIdGenerator;
import de.hsos.shared.id.IdGenerationQualifier;
import de.hsos.shared.id.IdGenerationType;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerManagement customerManagement;

    @Inject
    @IdGenerationQualifier(type = IdGenerationType.CUSTOMER)
    CustomerIdGenerator idGenerator;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        return Response.ok(this.customerManagement.getAllCustomers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(CustomerCreationDTO creationDTO) {
        Integer id = idGenerator.generateId();
        CustomerCreationWithIdDTO creationWithIdDTO = new CustomerCreationWithIdDTO(creationDTO.firstName, creationDTO.lastName, id);

        return Response.ok(this.customerManagement.createCustomer(creationWithIdDTO)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") Integer id) {

        CustomerDTO customerDTO = this.customerManagement.getCustomerById(id);

        if (customerDTO != null) {
            return Response.ok(customerDTO).build();
        } else {
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomerById(@PathParam("id") Integer id) {
        return Response.ok(this.customerManagement.deleteCustomerById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/address/{id}")
    public Response createAddressForCustomerById(@PathParam("id") Integer id, AddressDTO addressDTO) {

        return Response.ok(this.customerManagement.createAddressForCustomerById(id, addressDTO)).build();
    }

    @PUT
    @Path("/address/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeCustomerAddress(@PathParam("id") Integer id, AddressDTO addressDTO) {
        return Response.ok(this.customerManagement.updateAddressFromCustomerById(id, addressDTO)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/address/{id}")
    public Response getAddressFromCustomerById(@PathParam("id") Integer id) {

        return Response.ok(this.customerManagement.getAddressFromCustomerById(id)).build();
    }


    @DELETE
    @Path("/address/{id}")
    public Response deleteCustomerAddress(@PathParam("id") Integer id) {
        return Response.ok(this.customerManagement.deleteAddressFromCustomerById(id)).build();
    }

}
