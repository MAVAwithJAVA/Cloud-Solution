package sr.qualogy.service;



import sr.qualogy.reportchain.AdminReportHandler;
import sr.qualogy.reportchain.ReportRequest;
import sr.qualogy.reportresultset.ReportResult;

import java.util.List;

public class TravelReportService {

    private AdminReportHandler adminReportHandler = new AdminReportHandler();

    public List<? extends ReportResult> getReport(ReportRequest request) {
        return adminReportHandler.startHandling(request);
    }

}
