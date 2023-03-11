package de.hsos.swa.mocktail.boundary.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.utils.topic.mocktail.MocktailIngredientCreationDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailIngredientDTO;
import de.hsos.swa.utils.topic.mocktail.MocktailCreationDTO;
import de.hsos.swa.mocktail.control.MocktailManagement;
import de.hsos.swa.mocktail.entity.Ingredient;
import de.hsos.swa.mocktail.entity.Mocktail;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/mocktails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailResource {
    // Logger created
    private static final Logger log = Logger.getLogger(MocktailResource.class.getName());
    public int invocationNumber = 0;

    @Inject
    MocktailManagement mocktailManagement;

    @Operation(summary = "Creates Mockdata", description = "Creates Mockdata for demonstration")
    @Retry(maxRetries = 5)
    //Since we allowed 3 retries, it would require 4 invocations to fail in a row, in order for the user to be actually exposed to a failure.
    @Timeout(250)
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MocktailResource.class))))
    @PostConstruct
    public void init() {
        log.debug(System.currentTimeMillis() + " START: MocktailResource init() ");
        log.info("getting Mock Data");
        this.mocktailManagement.addMocktail("1", "Gin Tonic");
        this.mocktailManagement.addIngredient("1",
                new MocktailIngredientDTO("Ice Cubes", 3),
                new MocktailIngredientDTO("Gin", 1),
                new MocktailIngredientDTO("Tonic Water", 1),
                new MocktailIngredientDTO("Lemon", 1)
        );

        this.mocktailManagement.addMocktail("2", "Thirst Zapper");
        this.mocktailManagement.addIngredient("2",
                new MocktailIngredientDTO("Ice Cubes", 2),
                new MocktailIngredientDTO("Soda", 1),
                new MocktailIngredientDTO("Woodruff", 1)
        );

        this.mocktailManagement.addMocktail("3", "Carl Wheezer");
        this.mocktailManagement.addIngredient("3",
                new MocktailIngredientDTO("Orange", 2),
                new MocktailIngredientDTO("Soda", 1),
                new MocktailIngredientDTO("Pineapple Juice", 1)
        );

        log.debug(System.currentTimeMillis() + " END: MocktailResource init() ");
    }

    @Counted(name = "getAllMocktailsCounter", description = "How many 'getAllMocktails' have been performed")
    @Timed(name = "getAllMocktailsTimer", description = "A measure of how long it takes to perform 'getAllMocktails'.", unit = MetricUnits.MILLISECONDS)
    @GET
    @Retry(maxRetries = 5)
    @Timeout(250) //FixMe: Testat Fallback invoke demonstrieren (Orig: 250ms)
    @Fallback(fallbackMethod = "fallbackGetAllMocktails")
    @Operation(summary = "Get all Users", description = "List of all available Mocktails")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mocktail> getAllMocktails() throws InterruptedException {
        // Testing Fallback
        // Thread.sleep(100);

        log.debug(System.currentTimeMillis() + " START: MocktailResource getAllMocktails() ");
        log.info("getting all Mocktails");
        log.debug(System.currentTimeMillis() + " END: MocktailResource getAllMocktails() ");
        return this.mocktailManagement.getAllMocktails();
    }

    @Counted(name = "getMocktailCounter", description = "How many 'getMocktail' have been performed")
    @Timed(name = "getMocktailTimer", description = "A measure of how long it takes to perform 'getMocktail'.", unit = MetricUnits.MILLISECONDS)
    @GET
    @Fallback(fallbackMethod = "fallbackGetMocktail")
    @Retry(maxRetries = 5)
    @Timeout(250) //FixMe: Testat Fallback invoke demonstrieren
    @Path("{id}")
    @Operation(summary = "Gets specific mocktail", description = "Gets a specific mocktail with an id")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))
    public Response getMocktail(@PathParam("id") String id) throws InterruptedException {
        log.debug(System.currentTimeMillis() + " START: MocktailResource getMocktail() ");
        log.info("getting Mocktail");

        // Testing Fallback
        //Thread.sleep(100);

        Mocktail m = this.mocktailManagement.getMocktail(id);
        log.debug(System.currentTimeMillis() + " END: MocktailResource getMocktail() ");
        return Response.ok(m).build();
    }

    @Counted(name = "newMocktailCounter", description = "How many 'newMocktail' have been performed")
    @Timed(name = "newMocktailTimer", description = "A measure of how long it takes to perform 'newMocktail'.", unit = MetricUnits.MILLISECONDS)
    @POST
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Operation(summary = "Adds a Mocktail", description = "Creates a user")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMocktail(MocktailCreationDTO mocktailCreationDTO) {
        log.debug(System.currentTimeMillis() + " START: MocktailResource newMocktail() ");
        log.info("creating new Mocktail");

        this.mocktailManagement.addMocktail(mocktailCreationDTO.getId(), mocktailCreationDTO.getName());
        log.debug(System.currentTimeMillis() + " END: MocktailResource newMocktail() ");
        return Response.ok(mocktailCreationDTO).build();
    }

    @Counted(name = "newIngredientCounter", description = "How many 'newIngredient' have been performed")
    @Timed(name = "newIngredientTimer", description = "A measure of how long it takes to perform 'newIngredient'.", unit = MetricUnits.MILLISECONDS)
    @POST
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Path("{id}")
    @Operation(summary = "Adds an ingredient", description = "Adds an ingredient to a mocktail with an id")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newIngredient(@PathParam("id") String id, MocktailIngredientCreationDTO ingredientCreationDTO) {
        log.debug(System.currentTimeMillis() + " START: MocktailResource newIngredient() ");
        log.info("adding new Ingredient to Mocktail " + id);

        MocktailIngredientDTO i = new MocktailIngredientDTO(ingredientCreationDTO.getName(), ingredientCreationDTO.getQuantity());
        this.mocktailManagement.addIngredient(id, i);
        log.debug(System.currentTimeMillis() + " END: MocktailResource newIngredient() ");
        return Response.ok(i).build();
    }

    @Counted(name = "updateMocktailCounter", description = "How many 'updateMocktail' have been performed")
    @Timed(name = "updateMocktailTimer", description = "A measure of how long it takes to perform 'updateMocktail'.", unit = MetricUnits.MILLISECONDS)
    @PUT
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Path("{id}")
    @Operation(summary = "Updates a name of a mocktail", description = "Updates a name of a mocktail with an id")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))
    @APIResponse(responseCode = "404", description = "Mocktail not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class)))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMocktail(@PathParam("id") String id, MocktailCreationDTO mocktailCreationDTO) {
        log.debug(System.currentTimeMillis() + " START: MocktailResource updateMocktail() ");
        log.info("updating  Mocktail");
        this.mocktailManagement.updateMocktail(id, mocktailCreationDTO.getName());

        log.debug(System.currentTimeMillis() + " END: MocktailResource updateMocktail() ");
        return Response.ok(mocktailCreationDTO).build();
    }

    @Counted(name = "deleteMocktailCounter", description = "How many 'deleteMocktail' have been performed")
    @Timed(name = "deleteMocktailTimer", description = "A measure of how long it takes to perform 'deleteMocktail'.", unit = MetricUnits.MILLISECONDS)
    @DELETE
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Operation(summary = "Deletes a mocktail", description = "Deletes a mocktail with an id")
    @APIResponses(value = {@APIResponse(responseCode = "204", description = "Success"), @APIResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class)))})
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMocktail(@PathParam("id") String id) {
        log.debug(System.currentTimeMillis() + " START: MocktailResource deleteMocktail() ");
        log.info("Deleting Mocktail");
        boolean removed = this.mocktailManagement.deleteMocktail(id);
        if (removed) {
            log.info("Deleting Mocktail was successful");
            return Response.noContent().build();
        } else {
            log.warn("Deleting Mocktail was not successful");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Counted(name = "deleteMocktailIngredientCounter", description = "How many 'deleteMocktailIngredient' have been performed")
    @Timed(name = "deleteMocktailIngredientTimer", description = "A measure of how long it takes to perform 'deleteMocktailIngredient'.", unit = MetricUnits.MILLISECONDS)
    @DELETE
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Operation(summary = "Deletes a mocktail Ingredient", description = "Deletes a Ingredient by Mocktail id and index")
    @APIResponses(value = {@APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))), @APIResponse(responseCode = "404", description = "Mocktail not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class)))})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMocktailIngredient(@QueryParam("id") String id, @QueryParam("index") int index) {
        log.debug(System.currentTimeMillis() + " START: MocktailResource deleteMocktailIngredient() ");
        log.info("Deleting Ingredient from Mocktail " + id);
        boolean removed = this.mocktailManagement.deleteIngredient(id, index);
        if (removed) {
            log.info("Deleting Ingredient was successful");
            return Response.noContent().build();
        } else {
            log.warn("Deleting Ingredient was not successful");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    /*

    @Counted(name = "helloCounter", description = "How many 'hello' have been performed")
    @Timed(name = "helloTimer", description = "A measure of how long it takes to perform 'hello'.", unit = MetricUnits.MILLISECONDS)
    @GET
    @Retry(maxRetries = 5)
    @CircuitBreaker(requestVolumeThreshold = 3)
    @Timeout(250)
    @Operation(summary = "Welcomes User", description = "Welcomes User with a Message")
    @Gauge(name = "highestTestNumberSoFar", unit = MetricUnits.NONE, description = "Highest test number so far.")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MocktailResource.class))))
    @Produces(MediaType.APPLICATION_JSON)
    public int hello() {
        return 12345;
    }
    */


    @SuppressWarnings("All")
    private Response fallbackGetMocktail(String id) {
        Mocktail m = new Mocktail("Fallback-Mocktail", "1000");
        m.addIngredient(
                new Ingredient("Fallback-Ingredient-1", 1),
                new Ingredient("Fallback-Ingredient-2", 1),
                new Ingredient("Fallback-Ingredient-3", 1),
                new Ingredient("Fallback-Ingredient-4", 1));

        log.warn("Fallback: GetMocktail invoked");
        return Response.ok(m).build();
    }

    @SuppressWarnings("All")
    private Collection<Mocktail> fallbackGetAllMocktails() {


        Mocktail m1 = new Mocktail("Fallback-Mocktail-1", "1000");
        m1.addIngredient(
                new Ingredient("Fallback-Ingredient-1", 1),
                new Ingredient("Fallback-Ingredient-2", 1),
                new Ingredient("Fallback-Ingredient-3", 1),
                new Ingredient("Fallback-Ingredient-4", 1));

        Mocktail m2 = new Mocktail("Fallback-Mocktail-1", "1000");
        m2.addIngredient(
                new Ingredient("Fallback-Ingredient-1", 1),
                new Ingredient("Fallback-Ingredient-2", 1),
                new Ingredient("Fallback-Ingredient-3", 1),
                new Ingredient("Fallback-Ingredient-4", 1));

        Mocktail m3 = new Mocktail("Fallback-Mocktail-1", "1000");
        m3.addIngredient(
                new Ingredient("Fallback-Ingredient-1", 1),
                new Ingredient("Fallback-Ingredient-2", 1),
                new Ingredient("Fallback-Ingredient-3", 1),
                new Ingredient("Fallback-Ingredient-4", 1));

        List<Mocktail> fallbackList = new ArrayList<>();

        fallbackList.add(m1);
        fallbackList.add(m2);
        fallbackList.add(m3);

        log.warn("Fallback: GetAllMocktails invoked");


        return fallbackList;
    }
}
