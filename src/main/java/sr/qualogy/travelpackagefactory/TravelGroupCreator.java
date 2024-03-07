package sr.qualogy.travelpackagefactory;



import sr.qualogy.entity.Traveler;

import java.util.List;

public interface TravelGroupCreator {

    public void addTravelGroupToDatabase(List<Traveler> travelerList);
}
