package managerScore;

public class Util {
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

    public static String formatString(Student student) {
        int totalScore = Integer.parseInt(student.getMath()) + Integer.parseInt(student.getLanguage())
                + Integer.parseInt(student.getEnglish()) + Integer.parseInt(student.getProgram());
        float averageScore = (float) (totalScore / 4.0);
        return String.format("%s|%s|%s|%s|%s|%s|%s\n", student.getName(), student.getMath(), student.getLanguage(),
                student.getEnglish(), student.getProgram(), Float.toString(averageScore), Integer.toString(totalScore));
    }
}
