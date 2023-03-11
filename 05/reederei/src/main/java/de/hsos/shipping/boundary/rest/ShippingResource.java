package de.hsos.shipping.boundary.rest;

import de.hsos.ordermanagement.entity.CreateEvent;
import de.hsos.ordermanagement.entity.Orders;
import de.hsos.ordermanagement.utils.eventdto.CreateEventDTO;
import de.hsos.ordermanagement.utils.eventdto.DeleteEventDTO;
import de.hsos.ordermanagement.utils.eventdto.UpdateEventDTO;
import de.hsos.ordermanagement.utils.id.IdGeneration;
import de.hsos.ordermanagement.utils.id.IdGenerationQualifier;
import de.hsos.ordermanagement.utils.id.IdGenerationType;
import de.hsos.playground.Student;
import de.hsos.playground.StudentManager;
import de.hsos.shipping.control.ShippingManagement;
import de.hsos.shipping.entity.Ship;
import de.hsos.shipping.utils.dto.PostShipDTO;
import de.hsos.shipping.utils.dto.PostShipDTOWithId;
import de.hsos.shipping.utils.dto.ShipDTO;
import de.hsos.shipping.utils.uri.UriBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;


@Path("/shipping")
public class ShippingResource {

    @Inject
    ShippingManagement shippingManagement;

    @Inject
    @IdGenerationQualifier(type = IdGenerationType.SHIPPING)
    IdGeneration shippingId;


    @Inject
    UriBuilder uriBuilder;


    @Context
    UriInfo uriInfo;


    /*
    @Inject
    EntityManager entityManager;
    */


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllShips")
    public Response getAllShips() {
        Collection<ShipDTO> ships = this.shippingManagement.getAllShips();

        if (ships != null) {
            return Response.ok(ships).build();
        } else {
            return Response.noContent().build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getShip/{id}")
    public Response getShipById(@PathParam("id") Integer id) {

        ShipDTO shipDTO = this.shippingManagement.getShip(id);

        System.out.println(shipDTO);

        if (shipDTO != null) {
            return Response.ok(shipDTO).build();
        } else {
            return Response.noContent().build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createShip")
    public Response createShip(PostShipDTO postShipDTO) {
        Integer id = this.shippingId.generateId();
        PostShipDTOWithId dto = new PostShipDTOWithId(id, postShipDTO.name);
        this.addSelfLinkToShip(dto);

        return Response.ok(this.shippingManagement.createShip(dto)).build();
    }


    private void addSelfLinkToShip(PostShipDTOWithId shipDTO) {
        URI selfUri = this.uriBuilder.forShip(Long.valueOf(shipDTO.id), this.uriInfo);
        Link link = Link.fromUri(selfUri)
                .type(MediaType.APPLICATION_JSON)
                .build();
        shipDTO.shipLink = link.getUri();
    }

    /*
    private void addSelfLinkToTeam(TeamDataGetAll team) {
        URI selfUri = this.resourceUriBuilder.forTeam(Long.valueOf(team.id), this.uriInfo);
        Link link = Link.fromUri(selfUri)
                .type(MediaType.APPLICATION_JSON)
                .build();
        team.links.self = String.valueOf(link.getUri());

        // Link is correct
        System.out.println(link.getUri());
    }

     */


    //******* PLAYGROUND FOR TESTING ******** //

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generateIdTest")
    public Response hello() {

        Integer tmp = shippingId.generateId();
        System.out.println(tmp);
        return Response.ok(tmp).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fireEventTest")
    public Response fire(@QueryParam("name") String name){

        s.enroll(name);
        return Response.ok(s).build();
    }
    */

}