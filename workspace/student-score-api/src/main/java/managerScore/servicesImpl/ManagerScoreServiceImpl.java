package managerScore.servicesImpl;

import managerScore.*;
import managerScore.models.ReportItem;
import managerScore.services.KlassService;
import managerScore.services.ReportService;
import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerScoreServiceImpl implements managerScore.services.ManagerScoreService {
    @Autowired
    private KlassService klassService;
    @Autowired
    private  ReportService reportService;
    private Klass klass = new Klass();


    @Override
    public Report getAllReport() {
       ArrayList<ReportItem> reportItemArrayList = reportService.getReportItem(klass);
        float averageOfClass = klassService.getAverageOfClass(klass);
        float medianOfClass = klassService.getMedianOfClass(klass);
        Report report = new Report((ArrayList<ReportItem>) reportItemArrayList, averageOfClass, medianOfClass);
        return report;
    }

    @Override
    public List<Student> addStudent(Student student) {
        List<Student> studentInfoList = klassService.addStudentInfo(klass, student);
        return studentInfoList;
    }

}
