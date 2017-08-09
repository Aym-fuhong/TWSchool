package managerScore;

import managerScore.models.Student;

public class IOFilter {

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
}
