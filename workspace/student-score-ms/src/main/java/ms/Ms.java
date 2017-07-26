package ms;

public class Ms {
    private Constant constant = new Constant();

    public String print_studnent_score_ms(String input) {
        String result = "";
        if ("1".equals(input)) {
            result = constant.getAddStudentPromptString();
        } else {
            result = constant.getMenuString();
        }
        return result;
    }
}
