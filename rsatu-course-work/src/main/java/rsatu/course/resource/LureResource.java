package rsatu.course.resource;


import rsatu.course.pojo.Lure;
import rsatu.course.service.LureService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/lure")
public class LureResource {
    @Inject
    LureService lureService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getLures() {
        return Response.ok(lureService.getAllLures()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateLure(Lure lure) {
        return Response.ok(lureService.updateLure(lure)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertLure(Lure lure) {
        return Response.ok(lureService.insertLure(lure)).build();
    }
}
