package managerScore;

import managerScore.controller.ManagerScore;
import managerScore.interfaces.StudentInterface;
import managerScore.models.Student;
import managerScore.services.StudentService;

public class IOFilter {
    private StudentInterface studentInterface = new StudentService();

    public void setStatus(ManagerScore managerScore , String input) {
        if (Status.wait_input.equals(managerScore.getCurrentStatus()) && input.trim().matches("[123]")) {
            if("1".equals(input)){
                managerScore.setCurrentStatus(Status.wait_add_student_info);
            } else  if("2".equals(input)){
                managerScore.setCurrentStatus(Status.wait_get_student_score_report);
            } else  if("3".equals(input)){
                managerScore.setCurrentStatus(Status.exit);
            }
        }
    }

    public static boolean formatOneInput(String input) {
        boolean isFormated = false;
        if (input.matches("(.+)，(.+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)")) {
            isFormated = true;
        }
        return isFormated;
    }

    public static boolean formatTwoInput(String input) {
        boolean isFormated = false;
        if (input.matches("(\\d+)(，\\d+)*")) {
            isFormated = true;
        }
        return isFormated;
    }

    public String formatString(Student student) {
        return String.format("%s|%s|%s|%s|%s|%s|%s\n", student.getName(), student.getMath(), student.getLanguage(),
                student.getEnglish(), student.getProgram(), studentInterface.getStudentTotalScore(student) / 4.0,
                studentInterface.getStudentTotalScore(student));
    }
}
