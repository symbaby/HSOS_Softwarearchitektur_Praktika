package de.hsos.boundary.page;

import de.hsos.control.management.OrderingManagement;
import de.hsos.control.management.PizzaManagement;
import de.hsos.entity.OrderPosition;
import de.hsos.gateway.CustomerRepository;
import de.hsos.shared.dto.CustomerGetDTO;
import de.hsos.shared.dto.DeleteOrderPositionDTO;
import de.hsos.shared.dto.OrderPositionDTO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ui/orders")
@Produces(MediaType.TEXT_HTML)
public class OrderPage {

    @Inject
    OrderingManagement orderingManagement;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    PizzaManagement pizzaManagement;

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance PizzaAddForm();
        public static native TemplateInstance PizzaSubmitted();

    }

    @GET
    @PermitAll
    @Path("/{customerId}")
    public Response getOrderForm(@PathParam("customerId") long customerId) {

        return Response.ok(Templates.PizzaAddForm().data("OrderPositions", this.customerRepository.getCustomer(customerId))).build();
    }

    @POST
    @PermitAll
    @Path("/{customerId}")
    public Response orderPizza(@PathParam("customerId") long customerId, @FormParam("pizzaId") long pizzaId, @FormParam("pizzaQuantity") int qty) {

        String pizzaName = pizzaManagement.getPizza(pizzaId).name;
        OrderPositionDTO orderPositionDTO = new OrderPositionDTO(pizzaId, qty, pizzaName);
        this.orderingManagement.createOrderPosition(customerId, orderPositionDTO);

        return Response.ok(Templates.PizzaAddForm().data("OrderPositions", this.customerRepository.getCustomer(customerId))).build();
    }

    @POST
    @PermitAll
    @Path("/delete/{customerId}")
    public Response deletePizza(@PathParam("customerId") long customerId, @FormParam("pizzaId") long pizzaId) {

        DeleteOrderPositionDTO deleteOrderPositionDTO = new DeleteOrderPositionDTO(pizzaId);
        this.orderingManagement.deleteOrderPosition(customerId, deleteOrderPositionDTO);

        return Response.ok(Templates.PizzaAddForm().data("OrderPositions", this.customerRepository.getCustomer(customerId))).build();
    }

    @POST
    @PermitAll
    @Path("/update/{customerId}")
    public Response updatePizza(@PathParam("customerId") long customerId, @FormParam("pizzaId") long pizzaId, @FormParam("pizzaQuantity") int qty) {

        String pizzaName = pizzaManagement.getPizza(pizzaId).name;
        OrderPositionDTO orderPositionDTO = new OrderPositionDTO(pizzaId, qty, pizzaName);
        this.orderingManagement.updateOrderPosition(customerId, orderPositionDTO);

        return Response.ok(Templates.PizzaAddForm().data("OrderPositions", this.customerRepository.getCustomer(customerId))).build();
    }

    @GET
    @PermitAll
    @Path("/{customerId}/submit")
    public Response submitOrder(@PathParam("customerId") Long id){
        return Response.ok(Templates.PizzaSubmitted().data(this.orderingManagement.submitOrder(id))).build();
    }

}

