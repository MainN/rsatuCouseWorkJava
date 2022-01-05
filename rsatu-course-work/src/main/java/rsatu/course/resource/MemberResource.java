package rsatu.course.resource;

import rsatu.course.pojo.Member;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/member")
public class MemberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getMembers() {
        return Response.ok(Member.findAllMembers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByIdComp")
    public Response getMembersByIdComp(Long id) {
        return Response.ok(Member.findMembersByIdComp(id)).build();
    }
}
