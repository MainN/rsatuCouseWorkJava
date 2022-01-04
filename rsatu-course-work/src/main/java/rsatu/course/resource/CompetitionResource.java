package rsatu.course.resource;

import rsatu.course.pojo.Competition;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api/competition")
@ApplicationScoped
public class CompetitionResource {

    @Transactional
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/get")
    public Response getCompetitions() {
        return Response.ok(Competition.findAllCompetitions()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @Transactional
    public Response insertCompetition(Competition competition) {
        return Response.ok(Competition.insertCompetition(competition)).build();
    }
}
