package managerScore.servicesImpl;

import managerScore.*;
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
    private Klass klass = new Klass();

    public String return_add_student_info_when_input_1(String input) {
//        String result = Constant.errString + Constant.addStudentFormat;
//        if (IOFilter.formatOneInput(input)) {
//            List<Student> studentInfoList = klassInterface.addStudentInfo(klass, input);
//            result = "学生" + studentInfoList.get(studentInfoList.size() - 1).getName()
//                    + "的成绩被添加\n" + Constant.menuString;
//        }
//        return result;
        return "";
    }

    public String return_student_score_and_info_when_input_2(String input) {
//        String result = Constant.errString + Constant.studentIdPrompt;
//        if (IOFilter.formatTwoInput(input)) {
//            ArrayList<Student> studentList = klassInterface.getStudentList(klass, input);
//            float averageOfClass = klassInterface.getAverageOfClass(klass);
//            float medianOfClass = klassInterface.getMedianOfClass(klass);
//            result = reportInterface.getStudentScoreString(new Report(studentList, averageOfClass, medianOfClass))
//                    + Constant.menuString;
//        }
//        return result;
        return "";
    }

    @Override
    public Report getReport(String id) {
        ArrayList<Student> studentList = klassService.getStudentList(klass, id);
        float averageOfClass = klassService.getAverageOfClass(klass);
        float medianOfClass = klassService.getMedianOfClass(klass);
        Report report = new Report(studentList, averageOfClass, medianOfClass);
        return report;
    }

    @Override
    public Report getAllReport() {
        List<Student> studentList = klass.getAddStudentInfoList();
        float averageOfClass = klassService.getAverageOfClass(klass);
        float medianOfClass = klassService.getMedianOfClass(klass);
        Report report = new Report((ArrayList<Student>) studentList, averageOfClass, medianOfClass);
        return report;
    }

    @Override
    public List<Student> addStudent(Student student) {
        List<Student> studentInfoList = klassService.addStudentInfo(klass, student);
        return studentInfoList;
    }

}
