package sr.qualogy.reportchain;



import sr.qualogy.reportresultset.ReportResult;

import java.util.List;

public interface Chain {

    void setNextChain(Chain nextChain);

    List<? extends ReportResult> getReport(ReportRequest request);
}
