package managerScore;

import managerScore.managerScoreServices.ManagerScoreService;

public class ManagerScore {

    private Constant constant = new Constant();
    private ManagerScoreService managerScoreService = new ManagerScoreService();
    private String dealString;


    public String getDealString() {
        return dealString;
    }

    public void setDealString(String dealString) {
        this.dealString = dealString;
    }

    public void dealInput(String input) {
        if (input != null) {
            if (input.trim().matches("[123]")) {
                this.setDealString(input);
            }
        }
    }

    public String print_studnent_score_ms(String input) {
        String result = constant.getMenuString();
        this.dealInput(input);
        if ("1".equals(this.getDealString())) {
            result = constant.getAddStudentBegining() + constant.getAddStudentFormat();
            this.setDealString("1-*");
        } else if ("1-*".equals(this.getDealString())) {
            result = managerScoreService.return_add_student_info_when_input_1(input);
            this.setDealString("");
        } else if ("2".equals(this.getDealString())) {
            result = constant.getStudentIdPrompt();
            this.setDealString("2-*");
        } else if ("2-*".equals(this.getDealString())) {
            result = managerScoreService.return_student_score_and_info_when_input_2(input);
            this.setDealString("");
        }
        return result;
    }

}
