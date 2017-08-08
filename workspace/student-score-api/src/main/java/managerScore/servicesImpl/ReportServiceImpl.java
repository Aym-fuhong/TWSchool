package managerScore.servicesImpl;

import managerScore.Constant;
import managerScore.IOFilter;
import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.ReportItem;
import managerScore.models.Student;
import managerScore.services.KlassService;
import managerScore.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements managerScore.services.ReportService {
    @Autowired
    private StudentService studentService;

    public ArrayList<ReportItem> getReportItem(Klass klass){
       ArrayList<ReportItem> reportItemArrayList = new ArrayList<>();
        List<Student> studentList = klass.getAddStudentInfoList();
        for(int i=0; i< studentList.size(); i++){
            int totalScore = studentService.getStudentTotalScore(studentList.get(i));
            int averageScore = studentService.getStudentAverageScore(studentList.get(i));
            ReportItem reportItem = new ReportItem(studentList.get(i), totalScore, averageScore);
            System.out.println(reportItem);
            reportItemArrayList.add(reportItem);
        }
        return reportItemArrayList;
    }

}
