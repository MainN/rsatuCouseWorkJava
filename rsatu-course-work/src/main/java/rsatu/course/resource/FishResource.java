package rsatu.course.resource;

import rsatu.course.pojo.Fish;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/fish")
public class FishResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    @Transactional
    public Response getFishes() {
        return Response.ok(Fish.findAllFishes()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @Transactional
    public Response insertFish(Fish fish) {
        return Response.ok(Fish.insertFish(fish)).build();
    }
}
