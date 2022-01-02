package rsatu.course.resource;

import rsatu.course.pojo.Lake;
import rsatu.course.service.LakeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/lake")
public class LakeResource {
    @Inject
    LakeService lakeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getLakes() {
        return Response.ok(lakeService.getAllLakes()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateLake(Lake lake) {
        return Response.ok(lakeService.updateLake(lake)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertLake(Lake lake) {
        return Response.ok(lakeService.insertLake(lake)).build();
    }

}
