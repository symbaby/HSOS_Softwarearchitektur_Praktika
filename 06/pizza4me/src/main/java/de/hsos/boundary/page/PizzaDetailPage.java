package de.hsos.boundary.page;

import de.hsos.control.management.PizzaManagement;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ui/pizza")
@Produces(MediaType.TEXT_PLAIN)
public class PizzaDetailPage {

    @Inject
    PizzaManagement pizzaManagement;

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance PizzaDetail();
    }

    @GET
    @Path("details/{pizzaId}")
    public Response getDetailOfPizza(@PathParam("pizzaId") long pizzaId) {
        return Response.ok(Templates.PizzaDetail().data("pizzaDetails", this.pizzaManagement.getPizza(pizzaId))).build();
    }
}
