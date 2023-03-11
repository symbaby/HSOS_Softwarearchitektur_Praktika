package de.hsos.mannschaft.boundary.rest;

import de.hsos.mannschaft.control.TeamManagement;

import de.hsos.mannschaft.entity.Team;
import de.hsos.mannschaft.utils.dto.delete.PlayerBasicDataDelete;
import de.hsos.mannschaft.utils.dto.getAll.TeamDataGetAll;
import de.hsos.mannschaft.utils.dto.patch.TeamBasicDataPatch;
import de.hsos.mannschaft.utils.dto.patch.TeamDataPatch;
import de.hsos.mannschaft.utils.dto.post.PlayerBasicDataHolderPost;
import de.hsos.mannschaft.utils.dto.post.TeamDataPost;
import de.hsos.mannschaft.utils.uri.ResourceUriBuilder;

import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/teams")
public class TeamsResource {

    @Inject
    TeamManagement teamManagement;

    @Inject
    ResourceUriBuilder resourceUriBuilder;

    @Context
    UriInfo uriInfo;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeams() {

        Collection<TeamDataGetAll> t = this.teamManagement.getAllTeams();

        for (TeamDataGetAll team : t) {
           // teamsDTO.put(team.getId(), TeamDataGetAll.toDTO(team));
            addSelfLinkToTeam(team);
        }

        return Response.ok(t).build();
    }

    private void addSelfLinkToTeam(TeamDataGetAll team) {
        URI selfUri = this.resourceUriBuilder.forTeam(Long.valueOf(team.id), this.uriInfo);
        Link link = Link.fromUri(selfUri)
                .type(MediaType.APPLICATION_JSON)
                .build();
                team.links.self = String.valueOf(link.getUri());

                // Link is correct
        System.out.println(link.getUri());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTeam(TeamDataPost teamDataPost) {
        return Response.ok(this.teamManagement.addTeam(teamDataPost)).build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editTeam(TeamDataPatch teamDataPatch){
        return Response.ok(this.teamManagement.editTeam(teamDataPatch)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getTeamWithRelationship(@PathParam("id") String id){
        return Response.ok(this.teamManagement.getTeamWithRelationship(id)).build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/relationships/manager")
    public Response assignTrainerToTeam(@PathParam("id") String id, TeamBasicDataPatch teamBasicDataPatch){
        return Response.ok(this.teamManagement.assignTrainerToTeam(id, teamBasicDataPatch)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/relationships/players")
    public Response assignPlayersToTeam(@PathParam("id") String id, PlayerBasicDataHolderPost playerBasicDataHolderPost){
        return Response.ok(this.teamManagement.assignPlayersToTeam(id, playerBasicDataHolderPost)).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/relationships/players")
    public Response deletePlayerFromTeam(@PathParam("id") String id, PlayerBasicDataDelete playerBasicDataDelete){
        return Response.ok(this.teamManagement.deletePlayerFromTeam(id, playerBasicDataDelete)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/include")
    public Response teamWithManager(@QueryParam("include") String include,  @PathParam("id") String id){
        return Response.ok(this.teamManagement.getTeamWithManager(id, include)).build();
    }


}
