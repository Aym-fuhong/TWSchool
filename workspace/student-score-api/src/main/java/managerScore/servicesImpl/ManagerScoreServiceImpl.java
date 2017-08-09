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
    private ReportService reportService;

    @Override
    public Report getAllReport() {
        ArrayList<ReportItem> reportItemArrayList = reportService.getReportItem(klassService.createKlass());
        float averageOfClass = reportService.getAverageOfClass(klassService.createKlass());
        float medianOfClass = reportService.getMedianOfClass(klassService.createKlass());
        Report report = new Report(reportItemArrayList, averageOfClass, medianOfClass);
        return report;
    }

    @Override
    public List<Student> addStudent(Student student) {
        List<Student> studentInfoList = klassService.addStudentInfo(klassService.createKlass(), student);
        return studentInfoList;
    }

    @Override
    public ArrayList<Student> getAllStudentList() {
        ArrayList<Student> studentArrayList = klassService.getAllStudentList(klassService.createKlass());
        return studentArrayList;
    }
}
