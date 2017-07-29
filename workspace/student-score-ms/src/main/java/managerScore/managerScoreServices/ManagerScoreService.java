package managerScore.managerScoreServices;

import managerScore.*;
import java.util.ArrayList;
import java.util.List;


public class ManagerScoreService {

    private Constant constant = new Constant();
    private Klass klass = new Klass();
    private Report report = new Report();

   public String return_add_student_info_when_input_1(String input) {
        String result = constant.getErrString() + constant.getAddStudentFormat();
        if (Util.formatOneInput(input)) {
            List<Student> studentInfoList = klass.addStudentInfo(input);
            result = "学生" + studentInfoList.get(0).getName() + "的成绩被添加\n" + constant.getMenuString();
        }
        return result;
    }

    public String return_student_score_and_info_when_input_2(String input) {
        String result = constant.getErrString() + constant.getStudentIdPrompt();
        if (Util.formatTwoInput(input)) {
            ArrayList<Student> studentList = klass.getStudentList(input);
            float averageOfClass = klass.getAverageOfClass();
            float medianOfClass = klass.getMedianOfClass();
            result = report.getStudentScoreString(studentList,averageOfClass, medianOfClass) + constant.getMenuString();
        }
        return result;
    }

}
