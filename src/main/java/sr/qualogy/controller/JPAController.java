package sr.qualogy.controller;


import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sr.qualogy.configuration.JPAConfiguration;

@Path("/jpaController")
public class JPAController {

    private EntityManager entityManager;

    @Path("/startJPA")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String startJPA(){
        entityManager = JPAConfiguration.getEntityManager();
        return "JPA Started";
    }
}
