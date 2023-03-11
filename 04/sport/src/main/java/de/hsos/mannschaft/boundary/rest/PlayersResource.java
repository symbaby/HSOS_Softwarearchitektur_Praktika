package de.hsos.mannschaft.boundary.rest;

import de.hsos.mannschaft.acl.passwesen.IdGeneration;
import de.hsos.mannschaft.control.PlayerManagement;
import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/players")
public class PlayersResource {

    @Inject
    PlayerManagement playerManagement;

    // @Inject
    // IdGeneration playerId;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){



        return Response.ok().build();
    }

    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPlayerCondition(@PathParam("id")String id, PlayerAttributesPatch playerAttributesPatch){

        return Response.ok(this.playerManagement.setPlayerCondition(id, playerAttributesPatch)).build();
    }
}
