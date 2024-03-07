package sr.qualogy.service;



import sr.qualogy.dao.AccountDAO;
import sr.qualogy.dao.TravelPackageDAO;
import sr.qualogy.entity.Account;
import sr.qualogy.entity.TravelPackage;
import sr.qualogy.travelpackagefactory.TourPackageCreator;

import java.util.List;

public class TravelPackageService {
    private AccountDAO accountDAO = new AccountDAO();
    private TourPackageCreator tourPackageCreator = new TourPackageCreator();
    private TravelPackageDAO travelPackageDAO = new TravelPackageDAO();

    public boolean verifyAccount(Account account) {
        return accountDAO.verifyAccount(account.getUsername(), account.getPassword());
    }

    public TravelPackage addTravelPackage(Account credentials) {
        return tourPackageCreator.addTravelPackageToDatabase(credentials);
    }

    public List<TravelPackage> getTravelPackages(Account credentials) {
        return travelPackageDAO.retrieveAllTravelPackagesByAccount(credentials);
    }

    public boolean deleteTravelPackage(Long travelPackageId) {
        return travelPackageDAO.deleteTravelPackage(travelPackageId);

    }
}
