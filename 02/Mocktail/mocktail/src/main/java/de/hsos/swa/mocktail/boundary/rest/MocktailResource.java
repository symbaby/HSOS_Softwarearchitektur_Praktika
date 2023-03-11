package de.hsos.swa.mocktail.boundary.rest;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.mocktail.control.MocktailManagement;
import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;

@ApplicationScoped
@Path("/mocktails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailResource {

    @Inject
    MocktailManagement mocktailManagement;

    @PostConstruct
    public void init() {
        this.mocktailManagement.addMocktail("1", "Gin Tonic");
        this.mocktailManagement.addIngredient("1",
                new Ingredient("Ice Cubes", 3),
                new Ingredient("Gin", 1),
                new Ingredient("Tonic Water", 1),
                new Ingredient("Lemon", 1)
        );

        this.mocktailManagement.addMocktail("2", "Thirst Zapper");
        this.mocktailManagement.addIngredient("2",
                new Ingredient("Ice Cubes", 2),
                new Ingredient("Soda", 1),
                new Ingredient("Woodruff", 1)
        );

        this.mocktailManagement.addMocktail("3", "Carl Wheezer");
        this.mocktailManagement.addIngredient("3",
                new Ingredient("Orange", 2),
                new Ingredient("Soda", 1),
                new Ingredient("Pineapple Juice", 1)
        );
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mocktail> getAllMocktails() {
        return this.mocktailManagement.getAllMocktails();
    }

    @GET
    @Path("{id}")
    public Response getMocktail(@PathParam("id") String id) {
        Mocktail m = this.mocktailManagement.getMocktail(id);
        return Response.ok(m).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response newMocktal(@QueryParam("mocktailName") String name, @QueryParam("mocktailId") String id) {
        this.mocktailManagement.addMocktail(id, name);
        Mocktail m = this.mocktailManagement.getMocktail(id);
        return Response.ok(m).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newIngredient(@PathParam("id") String id, @QueryParam("ingredientName") String name, @QueryParam("ingredientQuantity") int quantity) {
        Ingredient i = new Ingredient(name, quantity);
        this.mocktailManagement.addIngredient(id, i);
        return Response.ok(i).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMocktail(@PathParam("id") String id, @QueryParam("newName") String name) {

        this.mocktailManagement.updateMocktail(id, name);
        Mocktail m = this.mocktailManagement.getMocktail(id);

        return Response.ok(m).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMocktail(@PathParam("id") String id) {
        boolean removed = this.mocktailManagement.deleteMocktail(id);
        System.out.println("delete mocktail");
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMocktailIngredient(@QueryParam("id") String id, @QueryParam("index") int index) {
        boolean removed = this.mocktailManagement.deleteIngredient(id, index);
        System.out.println("Delete Ingredient");
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
