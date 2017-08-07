package managerScore.servicesImpl;

import managerScore.*;
import managerScore.services.KlassService;
import managerScore.services.ReportService;
import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerScoreServiceImpl implements managerScore.services.ManagerScoreService {

    private Klass klass = new Klass();
    private KlassService klassInterface = new KlassServiceImpl();
    private ReportService reportInterface = new ReportServiceImpl();

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
        String result = Constant.errString + Constant.studentIdPrompt;
        if (IOFilter.formatTwoInput(input)) {
            ArrayList<Student> studentList = klassInterface.getStudentList(klass, input);
            float averageOfClass = klassInterface.getAverageOfClass(klass);
            float medianOfClass = klassInterface.getMedianOfClass(klass);
            result = reportInterface.getStudentScoreString(new Report(studentList, averageOfClass, medianOfClass))
                    + Constant.menuString;
        }
        return result;
    }

}
