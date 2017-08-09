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
        return reportService.getAllReport(klassService.createKlass());
    }

    @Override
    public List<Student> addStudent(Student student) {
        List<Student> studentInfoList = klassService.addStudentInfo(student);
        return studentInfoList;
    }

    @Override
    public ArrayList<Student> getAllStudentList() {
        ArrayList<Student> studentArrayList = klassService.getAllStudentList();
        return studentArrayList;
    }

    @Override
    public ArrayList<Student> getStudentById(String id) {
        ArrayList<Student> studentArrayList = klassService.getStudentList(id);
        return studentArrayList;
    }
}
