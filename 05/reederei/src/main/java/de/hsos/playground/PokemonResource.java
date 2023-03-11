package de.hsos.playground;

import de.hsos.shipping.entity.Ship;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Path("/test")
    @Transactional
    public void storeToDB(){
        Pokemon p1 = new Pokemon(100L, "Smogmog");
        Pokemon p2 = new Pokemon(101L, "Smogon");
        Pokemon p3 = new Pokemon(102L, "Arkbok");
        Pokemon p4 = new Pokemon(103L, "Kel Thuzad");

        this.entityManager.persist(p1);
        this.entityManager.persist(p2);
        this.entityManager.persist(p3);
        this.entityManager.persist(p4);
    }

    @GET
    @Path("/get/{id}")
    public Response getFromDB(@PathParam("id") Long id){
       Pokemon pokemon = entityManager.find(Pokemon.class, id);

       return Response.ok(pokemon).build();
    }

    @GET
    @Path("/getAll")
    public Response getAllFromDB(){
        List<Pokemon> s = this.entityManager.createNamedQuery("Pokemon.findAll", Pokemon.class).getResultList();

        for(Pokemon p : s){
            System.out.println(s);
        }

        return Response.ok(s).build();
    }

}
