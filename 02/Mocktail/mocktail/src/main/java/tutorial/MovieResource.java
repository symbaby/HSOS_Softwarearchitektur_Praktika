package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieResource {
    public static List<String> movies = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMovie() {
        return Response.ok(movies).build();

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countMovies() {
        return movies.size();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createMovie(String movie) {
        movies.add(movie);
        return Response.ok(movies).build();
    }

    @PUT
    @Path("{movieToUpdate}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateMovie(
        @PathParam("movieToUpdate") String movieToUpdate,
        @QueryParam("movie") String updateMovie) {
        movies = movies.stream().map(movie -> {
            if (movie.equals(movieToUpdate)) {
                return updateMovie;
            }
            return movie;
        }).collect(Collectors.toList());
        return Response.ok(movies).build();
    }

    @DELETE
    @Path("{movieToDelete}")
    @Consumes(MediaType.TEXT_PLAIN)
     public Response deleteMovie(
            @PathParam("movieToUpdate") String movieToDelete) {
        boolean removed = movies.remove(movieToDelete);

        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
