package sr.qualogy.reportchain;



import sr.qualogy.dao.TravelPackageDAO;
import sr.qualogy.reportresultset.ReportResult;

import java.util.List;

public class TravelerReports implements Chain {
    private Chain nextInChain;
    private TravelPackageDAO travelPackageDAO = new TravelPackageDAO();

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public List<? extends ReportResult> getReport(ReportRequest request) {
        if (request.getSelectedReport().equals("Traveler Report")) {
            return travelPackageDAO.frequencyOfTravelersByAge(request.getSelectedYear());
        } else {
            return nextInChain.getReport(request);
        }
    }
}

