package de.hsos.mannschaft.utils.uri;

import de.hsos.mannschaft.boundary.rest.TeamsResource;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;



//Beispiel aus der Vorlesung angepasst 
@ApplicationScoped
public class ResourceUriBuilder {

    public URI forTeam(Long id, UriInfo uriInfo) {
        return createResourceUri(TeamsResource.class,"getTeamWithRelationship",id, uriInfo);
    }

    private URI createResourceUri(Class<?> resourceClass,String method,Long id, UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method).build(id);
    }
}