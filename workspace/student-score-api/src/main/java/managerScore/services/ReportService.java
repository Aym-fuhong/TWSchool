package managerScore.services;
import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.ReportItem;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;

public interface ReportService {
    float getAverageOfClass(Klass klass);
    float getMedianOfClass(Klass klass);
    int getMedian(List<Student> list);
    int getStudentTotalScore(Student student);
    int getStudentAverageScore(Student student);
    ArrayList<ReportItem> getReportItem(Klass klass);
    Report getAllReport(Klass klass);
}
