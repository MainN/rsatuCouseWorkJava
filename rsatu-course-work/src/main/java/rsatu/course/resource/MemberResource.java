package rsatu.course.resource;

import rsatu.course.pojo.Member;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/member")
public class MemberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    @Transactional
    public Response getMembers() {
        return Response.ok(Member.findAllMembers()).build();
    }
}
