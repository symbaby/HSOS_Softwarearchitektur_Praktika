package de.hsos.boundary.page;

import de.hsos.control.management.PizzaManagement;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ui/pizzas")
@Produces(MediaType.TEXT_HTML)
public class PizzaPage {

    @Inject
    PizzaManagement pizzaManagement;

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance PizzaAll();
    }

    @GET
    @PermitAll
    public Response listPizzas(){
        return Response.ok(Templates.PizzaAll().data("PizzaAll",this.pizzaManagement.getAllPizza())).build();
    }


}
