package rsatu.course.resource;

import rsatu.course.pojo.Lake;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/lake")
public class LakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getLakes() {
        return Response.ok(Lake.findAllLakes()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @Transactional
    public Response insertLake(Lake lake) {
        return Response.ok(Lake.insertLake(lake)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    @Transactional
    public void deleteLakeById(Long id) {
        Lake.deleteLakeById(id);
    }

}
