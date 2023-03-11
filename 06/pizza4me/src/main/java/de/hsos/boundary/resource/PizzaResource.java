package de.hsos.boundary.resource;

import de.hsos.control.management.PizzaManagement;
import de.hsos.shared.dto.PizzaDTO;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pizza")
public class PizzaResource {

    @Inject
    PizzaManagement pizzaManagement;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAllPizza(){
        return Response.ok(this.pizzaManagement.getAllPizza()).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getPizza(@PathParam("id") Long id){
        return Response.ok(this.pizzaManagement.getPizza(id)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response createPizza(){
        return Response.ok(this.pizzaManagement.createPizza()).build();
    }


}
