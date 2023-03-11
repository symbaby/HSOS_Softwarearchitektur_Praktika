package de.hsos.ordermanagement.boundary.rest;

import de.hsos.ordermanagement.control.OrderManagement;
import de.hsos.ordermanagement.entity.Orders;
import de.hsos.ordermanagement.utils.dto.PostOrderDTO;
import de.hsos.ordermanagement.utils.dto.PostOrderWithIdDTO;
import de.hsos.ordermanagement.utils.dto.UpdateOrderDTO;
import de.hsos.ordermanagement.utils.id.IdGeneration;
import de.hsos.ordermanagement.utils.id.IdGenerationQualifier;
import de.hsos.ordermanagement.utils.id.IdGenerationType;
import de.hsos.playground.Student;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/orders")
public class OrderResource {

    @Inject
    @IdGenerationQualifier(type = IdGenerationType.ORDER)
    IdGeneration orderId;

    @Inject
    OrderManagement orderManagement;


    // get all Orders
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllOrders")
    public Response getAllOrders(){

        return Response.ok(this.orderManagement.getAllOrders()).build();
    }

    // get Order by id
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getOrder/{id}")
    public Response getOrderById(@PathParam("id")Integer id){

        return Response.ok(this.orderManagement.getOrder(id)).build();
    }

    // create Order
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createOrder")
    public Response createOrder(PostOrderDTO orderDTO){

        Integer id =  this.orderId.generateId();
        PostOrderWithIdDTO postOrderWithIdDTO = new PostOrderWithIdDTO(orderDTO.description, id);

        return Response.ok(this.orderManagement.createOrder(postOrderWithIdDTO)).build();
    }

    // update Order
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateOrder/{id}")
    public Response UpdateOrderById(@PathParam("id")Integer id, UpdateOrderDTO updateOrderDTO){

        return Response.ok(this.orderManagement.updateOrder(id, updateOrderDTO)).build();
    }

    // delete Order
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteOrder/{id}")
    public Response deleteOrderById(@PathParam("id")Integer id){

        return Response.ok(this.orderManagement.deleteOrder(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generateIdTest")
    public Response hello() {

        Integer tmp = orderId.generateId();
        System.out.println(tmp);
        return Response.ok(tmp).build();
    }
}
