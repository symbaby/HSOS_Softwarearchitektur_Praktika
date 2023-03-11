package de.hsos.boundary.resource;

import de.hsos.control.management.CustomerManagement;
import de.hsos.shared.dto.CustomerDTO;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
@RequestScoped
public class CustomerResource {

    @Inject
    CustomerManagement customerManagement;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response getAllCustomers() {
        return Response.ok(this.customerManagement.getAllCustomers()).build();
    }

    // /customers / GET / 200 OK / 204 No Content
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("admin")
    public Response getCustomer(@PathParam("id") Long id) {
        return Response.ok(this.customerManagement.getCustomer(id)).build();
    }
    // /customers/{id} / GET / 200 OK / 204 No Content


    // /customers / POST / 201 OK / 204 Error
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response createCustomer(CustomerDTO customerDTO) {
        return Response.ok(this.customerManagement.createCustomer(customerDTO)).build();
    }

    // /customer/{id} / PUT / 200 OK / 204 No Content
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response updateCustomer(@PathParam("id") Long id, CustomerDTO customerDTO) {
        return Response.ok(this.customerManagement.updateCustomer(id, customerDTO)).build();
    }

    // /customer/{id} / DELETE / 200 OK / 204 No Content
    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public Response deleteCustomer(@PathParam("id") Long id) {
        return Response.ok(this.customerManagement.deleteCustomer(id)).build();
    }
}