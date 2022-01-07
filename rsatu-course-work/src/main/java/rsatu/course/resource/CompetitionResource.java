package rsatu.course.resource;

import io.quarkus.security.Authenticated;
import rsatu.course.pojo.Competition;
import rsatu.course.pojo.Lake;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/competition")
@ApplicationScoped
public class CompetitionResource {

    @Transactional
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/get")
    @Authenticated
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{idCompetition}/addLake{idLake}")
    @Transactional
    public Response addLakeById(Long idCompetition, Long idLake) {
        Lake lake = Lake.findLakeById(idLake);
        Competition competition = Competition.findCompetitionById(idCompetition);
        if (lake != null && competition != null) {
            competition.lake = lake;
            return Response.ok(competition).build();
        }
        return Response.serverError().build();
    }
}
