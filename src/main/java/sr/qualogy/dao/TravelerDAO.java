package sr.qualogy.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.entity.TravelGroup;
import sr.qualogy.entity.Traveler;

import java.util.List;

public class TravelerDAO {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

    TravelGroupDAO travelGroupDAO = new TravelGroupDAO();

    public Traveler findTravelerByPassport(String passport) {
        String jpql = "select t from Traveler t where t.passport = :passport";
        TypedQuery<Traveler> query = entityManager.createQuery(jpql, Traveler.class);
        Traveler traveler = query.setParameter("passport", passport).getResultList().stream().findFirst().orElse(null);
        return traveler;
    }

    public List<Traveler> retrieveAllTravelers() {
        List<Traveler> travelerList;
        entityManager.getTransaction().begin();
        String jpql = "select t from Traveler t";
        Query query = entityManager.createQuery(jpql);
        travelerList = query.getResultList();
        entityManager.getTransaction().commit();
        System.out.println("travelerDAO ran");
//        JPAConfiguration.shutdown();
        return travelerList;
    }

    public Traveler insertTraveler(Traveler traveler) {
        entityManager.getTransaction().begin();
        entityManager.persist(traveler);
        entityManager.getTransaction().commit();
        System.out.println("Traveler has been inserted");
        return traveler;
    }

    public boolean updateTraveler(Traveler traveler) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Traveler t set t.firstName = :firstName, " +
                "t.lastName = :lastName," +
                "t.age = :age " +
                "where t.passport = :passport");
        query.setParameter("firstName", traveler.getFirstName());
        query.setParameter("lastName", traveler.getLastName());
        query.setParameter("passport", traveler.getPassport());
        query.setParameter("age", traveler.getAge());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated > 0;
    }

    public boolean deleteTraveler(String passport) {
        entityManager.getTransaction().begin();
        int rowsDeleted = 0;
        if (findTravelerByPassport(passport) != null) {
            TravelGroup travelGroup = travelGroupDAO.findTravelGroupByTraveler(passport);
            //Reizigers kan niet verwijdert worden als er maar 1 Reiziger in de Database voorkomt..!!!
            if (travelGroup.getTravelerCount() > 1) {
                String jpql1 = "delete from Traveler t where t.passport = :passport";
                Query query1 = entityManager.createQuery(jpql1);
                query1.setParameter("passport", passport);
                rowsDeleted = query1.executeUpdate();
                travelGroupDAO.updateTravelGroupDecreaseTravelerCount(travelGroup);
            } else {
                System.out.println("Only one traveler left in travel package \nRemoval of traveler not allowed");
            }
        } else {
            System.out.println("Traveler not found");
        }
        System.out.println("Travelers deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted > 0;
    }

}
