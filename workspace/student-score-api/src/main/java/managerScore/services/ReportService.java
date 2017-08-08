package managerScore.services;
import managerScore.models.Klass;
import managerScore.models.ReportItem;

import java.util.ArrayList;

public interface ReportService {
    ArrayList<ReportItem> getReportItem(Klass klass);
}
