package sr.qualogy.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.entity.TravelGroup;

import java.util.List;

public class TravelGroupDAO {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

    public TravelGroup findLastTravelGroupRecord() {
        entityManager.getTransaction().begin();
        String jpql = "select t from TravelGroup t order by t.travelGroupId desc";
        TypedQuery<TravelGroup> query = entityManager.createQuery(jpql, TravelGroup.class);
        List<TravelGroup> travelGroupList = query.setMaxResults(1).getResultList();
        TravelGroup lastTravelGroup = travelGroupList.get(0);
        entityManager.getTransaction().commit();
        return lastTravelGroup;
    }

    public TravelGroup findTravelGroupByTraveler(String passport) {
        String jpql = "select t from TravelGroup t join t.travelers tr where tr.passport = :passport";
        TypedQuery<TravelGroup> query = entityManager.createQuery(jpql, TravelGroup.class);
        List<TravelGroup> travelGroupList = query.setParameter("passport", passport).getResultList();
        TravelGroup travelGroup = null;
        if (!travelGroupList.isEmpty()) {
            travelGroup = travelGroupList.get(0);
        } else {
            System.out.println("No travel group found");
        }
        return travelGroup;
    }

//    public List<TravelGroup> findAllTravelGroups() {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("select t from TravelGroup t");
//        List<TravelGroup> travelGroupList = query.getResultList();
//        entityManager.getTransaction().commit();
//        return travelGroupList;
//    }
//
//    public List<TravelGroup> insertTravelGroupAndReturnLast(TravelGroup travelGroup) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(travelGroup);
//        TypedQuery<TravelGroup> query = entityManager.createQuery("select t from TravelGroup t order by t.travelGroupId desc", TravelGroup.class);
//        List<TravelGroup> lastTravelGroup = query.getResultList();
//        entityManager.getTransaction().commit();
//        return lastTravelGroup;
//    }

    public TravelGroup insertTravelGroup(TravelGroup travelGroup) {
        entityManager.getTransaction().begin();
        entityManager.persist(travelGroup);
        entityManager.getTransaction().commit();
//        System.out.println("Travel group has been inserted");
        return travelGroup;
    }

    public int updateTravelGroupDecreaseTravelerCount(TravelGroup travelGroup) {
//        entityManager.getTransaction().begin();
        String jpql = "update TravelGroup t set t.travelerCount = :travelerGroupUpdate where t.travelGroupId = :travelGroupId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("travelerGroupUpdate", travelGroup.getTravelerCount() - 1);
        query.setParameter("travelGroupId", travelGroup.getTravelGroupId());
        int rowsUpdated = query.executeUpdate();
        System.out.println("Travel group updated: " + rowsUpdated);
//        entityManager.getTransaction().commit();
        return rowsUpdated;
    }




}
