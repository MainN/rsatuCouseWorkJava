package rsatu.course.resource;

import rsatu.course.pojo.Member;
import rsatu.course.service.MemberService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/member")
public class MemberResource {

    @Inject
    MemberService memberService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getMembers() {
        return Response.ok(memberService.getAllMembers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateMember(Member member) {
        return Response.ok(memberService.updateMember(member)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertMember(Member member) {
        return Response.ok(memberService.insertMember(member)).build();
    }
}
