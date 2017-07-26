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

        } else if ("2-*".equals(this.getDealString())) {

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
//        if (input.matches(" ")) {
        if (true) {
            isFormated = true;
        }
        return isFormated;
    }

    private String return_add_student_info_when_input_1(String input) {
        String result = constant.getErrString() + constant.getAddStudentFormat();
        if (this.formatInput(input)) {
            String[] infoList = input.trim().split("，");
            Constant.studentInfoList.add(new Student(infoList[0], infoList[1], infoList[2].split("：")[1],
                    infoList[3].split("：")[1], infoList[4].split("：")[1], infoList[5].split("：")[1]));
            result = "学生" + infoList[0] + "的成绩被添加\n" + constant.getAddStudentFormat();
        }
        return result;
    }
}
