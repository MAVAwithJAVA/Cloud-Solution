package sr.qualogy.service;



import sr.qualogy.dao.TravelerDAO;
import sr.qualogy.entity.Traveler;
import sr.qualogy.travelpackagefactory.TourGroupCreator;

import java.util.List;

public class TravelGroupService {

    private TourGroupCreator tourGroupCreator = new TourGroupCreator();

    private TravelerDAO travelerDAO = new TravelerDAO();


    public List<Traveler> getTravelers() {
        return travelerDAO.retrieveAllTravelers();
    }

    public boolean addTravelers(List<Traveler> travelerList) {
        tourGroupCreator.addTravelGroupToDatabase(travelerList);
        return true;
    }

    public boolean updateTraveler(Traveler traveler) {
        return travelerDAO.updateTraveler(traveler);
    }

    public boolean deleteTraveler(String passport) {
        return travelerDAO.deleteTraveler(passport);
    }
}
