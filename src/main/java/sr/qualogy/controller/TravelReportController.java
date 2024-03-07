package sr.qualogy.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sr.qualogy.reportchain.ReportRequest;
import sr.qualogy.reportresultset.ReportResult;
import sr.qualogy.service.TravelReportService;

import java.util.List;

@Path("/travelReportController")
public class TravelReportController {

    private TravelReportService travelReportService = new TravelReportService();

    @Path("/getReport")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<? extends ReportResult> getReport(ReportRequest request) {
        System.out.println(travelReportService.getReport(request));
        return travelReportService.getReport(request);
    }

}
