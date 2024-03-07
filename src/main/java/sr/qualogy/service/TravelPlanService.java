package sr.qualogy.service;



import sr.qualogy.dao.DestinationDAO;
import sr.qualogy.entity.Destination;
import sr.qualogy.reportresultset.TravelPlanData;
import sr.qualogy.travelpackagefactory.TourPlanCreator;

import java.util.List;

public class TravelPlanService {

    private DestinationDAO destinationDAO = new DestinationDAO();
    private TourPlanCreator tourPlanCreator = new TourPlanCreator();

    public List<Destination> getDestinations() {
        return destinationDAO.retrieveDestinationList();
    }

    public boolean addTravelPlan(TravelPlanData travelPlanData) {
        tourPlanCreator.addTravelPlanToDatabase(travelPlanData);
        return true;
    }

    public boolean updateDestination(Destination destination) {
        return destinationDAO.updateDestination(destination);
    }

    public boolean deleteDestination(Long destinationId) {
        return destinationDAO.deleteDestination(destinationId);
    }
}
