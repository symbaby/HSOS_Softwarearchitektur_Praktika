package de.hsos.boundary.resource;

import de.hsos.control.management.OrderingManagement;
import de.hsos.shared.dto.DeleteOrderPositionDTO;
import de.hsos.shared.dto.OrderPositionDTO;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
@RequestScoped
public class OrderingResource {

    @Inject
    OrderingManagement orderingManagement;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}")
    @PermitAll
    public Response getCurrentOrder(@PathParam("customerId") Long customerId) {
        return Response.ok(this.orderingManagement.getCurrentOrder(customerId)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}/pizza")
    @PermitAll
    public Response createOrderPosition(@PathParam("customerId") Long id, OrderPositionDTO orderPositionDTO) {
        return Response.ok(this.orderingManagement.createOrderPosition(id, orderPositionDTO)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}")
    @PermitAll
    public Response updateOrderPosition(@PathParam("customerId") Long customerId, OrderPositionDTO orderPositionDTO) {
        return Response.ok(this.orderingManagement.updateOrderPosition(customerId, orderPositionDTO)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}")
    @PermitAll
    public Response deleteOrderPosition(@PathParam("customerId") long customerId, DeleteOrderPositionDTO deleteOrderPositionDTO){
        return Response.ok(this.orderingManagement.deleteOrderPosition(customerId, deleteOrderPositionDTO)).build();
    }



}
