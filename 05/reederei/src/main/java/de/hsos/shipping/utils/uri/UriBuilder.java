package de.hsos.shipping.utils.uri;

import de.hsos.shipping.boundary.rest.ShippingResource;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;


@ApplicationScoped
public class UriBuilder {

    public URI forShip(Long id, UriInfo uriInfo) {
        return createResourceUri(ShippingResource.class, "getShipById", id, uriInfo);
    }

    private URI createResourceUri(Class<?> resourceClass, String method, Long id, UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method).build(id);
    }
}