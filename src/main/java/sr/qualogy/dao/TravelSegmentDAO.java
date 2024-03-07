package sr.qualogy.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.entity.TravelSegment;

import java.util.List;

public class TravelSegmentDAO {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

//    public List<TravelSegment> retrieveTravelSegmentByDestinationFrequency() {
//        List<TravelSegment> travelSegmentList;
//        entityManager.getTransaction().begin();
//        String jpql = "select t from TravelSegment t join t.destination d group by d.destinationId order by count(d), d.destinationId";
//        TypedQuery<TravelSegment> query = entityManager.createQuery(jpql, TravelSegment.class);
//        travelSegmentList = query.getResultList();
//        entityManager.getTransaction().commit();
//        return travelSegmentList;
//    }

    public TravelSegment insertTravelSegment(TravelSegment travelSegment) {
        entityManager.getTransaction().begin();
        entityManager.persist(travelSegment);
        entityManager.getTransaction().commit();
        return travelSegment;
    }

}
