package managerScore;

public class Util {
    public static boolean formatOneInput(String input) {
        boolean isFormated = false;
        if (input.matches(" ")) {
            isFormated = true;
        }
        return isFormated;
    }

    public static boolean formatTwoInput(String input) {
        boolean isFormated = false;
        if (input.matches("1，2")) {
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
