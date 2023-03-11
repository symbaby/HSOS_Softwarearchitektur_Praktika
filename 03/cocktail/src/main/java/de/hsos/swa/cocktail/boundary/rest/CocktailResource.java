package de.hsos.swa.cocktail.boundary.rest;

import de.hsos.swa.cocktail.gateway.CocktailGateway;
import de.hsos.swa.utils.topic.cocktail.CocktailDTO;
import de.hsos.swa.utils.topic.cocktail.CocktailIngredientDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/cocktails")
@Produces(MediaType.APPLICATION_JSON)
public class CocktailResource {

    @Inject
    @RestClient
    CocktailGateway cocktailGateway;

    @GET
    @Path("/byCocktailName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCocktailByName(@PathParam("name") String name) {
        CocktailDTO cocktailDTO = this.cocktailGateway.getCocktailByName(name);
        return Response.ok(cocktailDTO).build();
        //return this.cocktailGateway.getCocktailByName(name);
    }

    @GET
    @Path("/byFirstLetter/{firstLetter}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCocktailByFirstLetter(@PathParam("firstLetter") String firstLetter) {
        // Response Object zureuckgeben
        CocktailDTO cocktailDTO = this.cocktailGateway.getCocktailByFirstLetter(firstLetter);
        return Response.ok(cocktailDTO).build();
        //return this.cocktailGateway.getCocktailByFirstLetter(firstLetter);
    }

    @GET
    @Path("/byIngredientName/{ingredientName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIngredientByName(@PathParam("ingredientName") String ingredientName) {
        CocktailIngredientDTO cocktailIngredientDTO = this.cocktailGateway.getIngredientByName(ingredientName);
        return Response.ok(cocktailIngredientDTO).build();
        //return this.cocktailGateway.getIngredientByName(ingredientName);
    }



    // Fixed: Fragen wie man richtig mit DTOS und Collections arbeitet. Wir hatten dabei Probleme...
    // Das Problem war das wir die JSON die von cocktaildb nicht als korrekte Java Klasse implementiert haben.
    // Nachdem wir die DTOs richtig abgebildet haben, kann JSONB serialisieren :)
    // Workaround mit JsonObject aber fuehlt sich unsauber an...

}
