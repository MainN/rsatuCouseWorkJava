package rsatu.course.resource;


import rsatu.course.pojo.Fish;
import rsatu.course.service.FishService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/fish")
public class FishResource {

    @Inject
    FishService fishService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getFishes() {
        return Response.ok(fishService.getAllFishes()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateFish(Fish fish) {
        return Response.ok(fishService.updateFish(fish)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertFish(Fish fish) {
        return Response.ok(fishService.insertFish(fish)).build();
    }
}
