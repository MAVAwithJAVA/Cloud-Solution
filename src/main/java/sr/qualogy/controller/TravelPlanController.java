package sr.qualogy.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.qualogy.entity.Destination;
import sr.qualogy.reportresultset.TravelPlanData;
import sr.qualogy.service.TravelPlanService;

import java.util.List;

@Path("/travelPlanController")
public class TravelPlanController {

    private TravelPlanService travelPlanService = new TravelPlanService();

    @Path("/getDestinations")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Destination> getDestinations() {
        return travelPlanService.getDestinations();
    }

    @Path("/addDestinations")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addTravelPlan(TravelPlanData travelPlanData) {
        return travelPlanService.addTravelPlan(travelPlanData);
    }

    @Path("/putDestination")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateTraveler(Destination destination) {
        return travelPlanService.updateDestination(destination);
    }

    @Path("/deleteDestination")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteDestination(Long destinationId) {
        return travelPlanService.deleteDestination(destinationId);
    }

}
