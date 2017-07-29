package managerScore.services;

import managerScore.*;
import managerScore.interfaces.KlassInterface;
import managerScore.interfaces.ManagerScoreInterface;
import managerScore.interfaces.ReportInterface;
import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;


public class ManagerScoreService implements ManagerScoreInterface {

    private Constant constant = new Constant();
    private Klass klass = new Klass();
    private KlassInterface klassInterface = new KlassService();
    private ReportInterface reportInterface = new ReportService();

    public String return_add_student_info_when_input_1(String input) {
        String result = constant.getErrString() + constant.getAddStudentFormat();
        if (Util.formatOneInput(input)) {
            List<Student> studentInfoList = klassInterface.addStudentInfo(klass, input);
            result = "学生" + studentInfoList.get(0).getName() + "的成绩被添加\n" + constant.getMenuString();
        }
        return result;
    }

    public String return_student_score_and_info_when_input_2(String input) {
        String result = constant.getErrString() + constant.getStudentIdPrompt();
        if (Util.formatTwoInput(input)) {
            ArrayList<Student> studentList = klassInterface.getStudentList(klass, input);
            float averageOfClass = klassInterface.getAverageOfClass(klass);
            float medianOfClass = klassInterface.getMedianOfClass(klass);
            result = reportInterface.getStudentScoreString(new Report(studentList, averageOfClass, medianOfClass))
                    + constant.getMenuString();
        }
        return result;
    }

}
