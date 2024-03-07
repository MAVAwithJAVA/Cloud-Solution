package sr.qualogy.controller;


import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.entity.Account;
import sr.qualogy.entity.TravelPackage;
import sr.qualogy.service.TravelPackageService;

import java.util.List;

@Path("travelPackageController")
public class TravelPackageController {

    private TravelPackageService travelPackageService = new TravelPackageService();

    @Path("/verifyAccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean verifyAccount(Account account) {
        return travelPackageService.verifyAccount(account);
    }

    @Path("/addTravelPackage")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelPackage addTravelPackage(Account credentials) {
        return travelPackageService.addTravelPackage(credentials);
    }

    @Path("/getTravelPackages")
//    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelPackage> getTravelPackages(Account credentials) {
        return travelPackageService.getTravelPackages(credentials);
    }

    @Path("/deleteTravelPackage")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteTravelPackage(Long travelPackageId) {
        return travelPackageService.deleteTravelPackage(travelPackageId);
    }


}
