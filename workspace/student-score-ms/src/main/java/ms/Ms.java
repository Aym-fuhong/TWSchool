package ms;

public class Ms {
    private Constant constant = new Constant();
    private String dealString = "";

    public String getDealString() {
        return dealString;
    }

    public void setDealString(String dealString) {
        this.dealString = dealString;
    }

    public String print_studnent_score_ms(String input) {
        String result = constant.getMenuString();
        this.dealInput(input);
        if ("1".equals(this.getDealString())) {
            result = constant.getAddStudentBegining() + constant.getAddStudentFormat();
            this.setDealString("1-*");
        } else if ("1-*".equals(this.getDealString())) {
            result = this.return_add_student_info_when_input_1(input);
        } else if ("2".equals(this.getDealString())) {

        } else {
            result = constant.getMenuString();
        }
        return result;
    }

    public void dealInput(String input) {
        if (input != null) {
            if (input.trim().matches("[123]")) {
                this.setDealString(input);
            }
        }
    }

    private boolean formatInput(String input) {
        boolean isFormated = false;
        if (input.matches(" ")) {

        }
        return isFormated;
    }

    private String return_add_student_info_when_input_1(String input) {
        String result = constant.getErrString() + constant.getAddStudentFormat();
        if (this.formatInput(input)) {

        }
        return result;
    }
}
