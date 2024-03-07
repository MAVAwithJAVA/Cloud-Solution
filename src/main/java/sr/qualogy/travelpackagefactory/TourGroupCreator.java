package sr.qualogy.travelpackagefactory;



import sr.qualogy.dao.TravelGroupDAO;
import sr.qualogy.dao.TravelerDAO;
import sr.qualogy.entity.TravelGroup;
import sr.qualogy.entity.Traveler;

import java.util.List;

public class TourGroupCreator implements TravelGroupCreator{

    private TravelGroup currentTravelGroup;
    private List<Traveler> currentTravelerList;

    private TravelerDAO travelerDAO = new TravelerDAO();
    private TravelGroupDAO travelGroupDAO = new TravelGroupDAO();

    @Override
    public void addTravelGroupToDatabase(List<Traveler> travelerList) {
        currentTravelerList = travelerList;
        currentTravelGroup = travelGroupDAO.insertTravelGroup(new TravelGroup(currentTravelerList.size()));
        for (Traveler traveler : currentTravelerList) {
            traveler.setTravelGroup(currentTravelGroup);
            travelerDAO.insertTraveler(traveler);
        }
    }
}
