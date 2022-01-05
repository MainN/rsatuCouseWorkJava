package rsatu.course.resource;

import rsatu.course.pojo.Fish;
import rsatu.course.pojo.Lure;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/lure")
public class LureResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getLures() {
        return Response.ok(Lure.findAllLures()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @Transactional
    public Response insertLure(Lure lure) {
        return Response.ok(Lure.insertLure(lure)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    @Transactional
    public void deleteLureById(Long id) {
        Lure.deleteLureById(id);
    }
}
