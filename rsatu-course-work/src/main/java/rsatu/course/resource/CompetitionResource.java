package rsatu.course.resource;

import rsatu.course.pojo.Competition;
import rsatu.course.service.CompetitionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/competition")
public class CompetitionResource {
    @Inject
    CompetitionService competitionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getCompetitions() {
        return Response.ok(competitionService.getAllCompetitions()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateCompetition(Competition competition) {
        return Response.ok(competitionService.updateCompetition(competition)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertCompetition(Competition competition) {
        return Response.ok(competitionService.insertCompetition(competition)).build();
    }
}
