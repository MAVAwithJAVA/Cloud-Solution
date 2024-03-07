package sr.qualogy.travelpackagefactory;


import sr.qualogy.dao.AccountDAO;
import sr.qualogy.dao.TravelGroupDAO;
import sr.qualogy.dao.TravelPackageDAO;
import sr.qualogy.dao.TravelPlanDAO;
import sr.qualogy.entity.Account;
import sr.qualogy.entity.TravelPackage;

public class TourPackageCreator implements TravelPackageCreator {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private TravelPackage travelPackage;

    private TravelPackageDAO travelPackageDAO = new TravelPackageDAO();
    private TravelGroupDAO travelGroupDAO = new TravelGroupDAO();
    private TravelPlanDAO travelPlanDAO = new TravelPlanDAO();
    private AccountDAO accountDAO = new AccountDAO();

    public TravelPackage addTravelPackageToDatabase(Account credentials) {
        Account account = accountDAO.retrieveAccount(credentials.getUsername(), credentials.getPassword());
        travelPackage = travelPackageDAO.insertTravelPackage(new TravelPackage(travelGroupDAO.findLastTravelGroupRecord(),
                travelPlanDAO.findLastTravelPlanRecord(), account));
        System.out.println("Travel Package has been added to database");
        System.out.println(travelPackage);
        return travelPackage;
    }

}
