package managerScore;

import managerScore.controller.ManagerScore;
import managerScore.interfaces.StudentInterface;
import managerScore.models.Student;
import managerScore.services.StudentService;

public class IOFilter {
    private StudentInterface studentInterface = new StudentService();

    public void setStatus(ManagerScore managerScore, String input) {
        if (Status.wait_input.equals(managerScore.getCurrentStatus()) && input.trim().matches("[123]")) {
            switch (input) {
                case "1":
                    managerScore.setCurrentStatus(Status.wait_add_student_info);
                    break;
                case "2":
                    managerScore.setCurrentStatus(Status.wait_get_student_score_report);
                    break;
                case "3":
                    managerScore.setCurrentStatus(Status.exit);
                    break;
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

    public static Student getStudentInfo(String input) {
        String[] infoList = input.trim().split("，");
        return new Student(infoList[0], infoList[1], infoList[2].split("：")[1],
                infoList[3].split("：")[1], infoList[4].split("：")[1], infoList[5].split("：")[1]);
    }

    public static String[] getStudentsId(String input) {
        String[] list = input.trim().split("，");
        return list;
    }

    public String formatString(Student student) {
        return String.format("%s|%s|%s|%s|%s|%s|%s\n", student.getName(), student.getMath(), student.getLanguage(),
                student.getEnglish(), student.getProgram(), studentInterface.getStudentTotalScore(student) / 4.0,
                studentInterface.getStudentTotalScore(student));
    }
}
