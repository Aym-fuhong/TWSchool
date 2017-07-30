package managerScore.controller;

import managerScore.Constant;
import managerScore.IOFilter;
import managerScore.interfaces.ManagerScoreInterface;
import managerScore.services.ManagerScoreService;

public class ManagerScore {

    private String currentStatus;

    private ManagerScoreInterface managerScoreInterface = new ManagerScoreService();

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void dealInput(String input) {
        if ("".equals(this.getCurrentStatus()) && input.trim().matches("[123]")) {
            this.setCurrentStatus(input);
        }
    }

    public String print_studnent_score_ms(String input) {
        String result = Constant.menuString;
        dealInput(input);
        if ("1".equals(this.getCurrentStatus())) {
            result = Constant.addStudentBegining + Constant.addStudentFormat;
            this.setCurrentStatus("1-*");
        } else if ("1-*".equals(this.getCurrentStatus())) {
            result = managerScoreInterface.return_add_student_info_when_input_1(input);
            if (result.indexOf(Constant.errString) == -1) {
                this.setCurrentStatus("");
            }
        } else if ("2".equals(this.getCurrentStatus())) {
            result = Constant.studentIdPrompt;
            this.setCurrentStatus("2-*");
        } else if ("2-*".equals(this.getCurrentStatus())) {
            result = managerScoreInterface.return_student_score_and_info_when_input_2(input);
            if (result.indexOf(Constant.errString) == -1) {
                this.setCurrentStatus("");
            }
        } else if ("3".equals(this.getCurrentStatus())) {
            System.exit(0);

        }
        return result;
    }

//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(constant.getMenuString());
//        while (scanner.hasNext()) {
//            String input = scanner.nextLine();
//            String result = print_studnent_score_ms(input);
//            System.out.println(result);
//        }
//    }

}
