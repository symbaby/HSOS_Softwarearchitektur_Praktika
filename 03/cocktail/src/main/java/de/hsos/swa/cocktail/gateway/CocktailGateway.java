package de.hsos.swa.cocktail.gateway;

import de.hsos.swa.utils.topic.cocktail.CocktailDTO;
import de.hsos.swa.utils.topic.cocktail.CocktailIngredientDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/v1/1")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "cocktailAPI")
public interface CocktailGateway {

    @GET
    @Path("/search.php")
    CocktailDTO getCocktailByName(@QueryParam("s") String name);

    @GET
    @Path("/search.php")
    CocktailDTO getCocktailByFirstLetter(@QueryParam("f") String firstLetter);

    @GET
    @Path("/search.php")
    CocktailIngredientDTO getIngredientByName(@QueryParam("i") String ingredientName);


}
