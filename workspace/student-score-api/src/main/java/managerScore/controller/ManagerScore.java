package managerScore.controller;

import managerScore.Constant;
import managerScore.IOFilter;
import managerScore.Status;
import managerScore.services.ManagerScoreService;
import managerScore.servicesImpl.ManagerScoreServiceImpl;

public class ManagerScore {

    private Status currentStatus = Status.wait_input;

    private ManagerScoreService managerScoreInterface = new ManagerScoreServiceImpl();

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String print_student_score_ms(String input) {
        String result = Constant.menuString;
        new IOFilter().setStatus(this, input);
        switch (this.currentStatus) {
            case wait_add_student_info:
                result = Constant.addStudentBegining + Constant.addStudentFormat;
                this.setCurrentStatus(Status.add_student_info);
                break;
            case add_student_info:
                result = managerScoreInterface.return_add_student_info_when_input_1(input);
                if (result.indexOf(Constant.errString) == -1) {
                    this.setCurrentStatus(Status.wait_input);
                }
                break;
            case wait_get_student_score_report:
                result = Constant.studentIdPrompt;
                this.setCurrentStatus(Status.get_student_score_report);
                break;
            case get_student_score_report:
                result = managerScoreInterface.return_student_score_and_info_when_input_2(input);
                if (result.indexOf(Constant.errString) == -1) {
                    this.setCurrentStatus(Status.wait_input);
                }
                break;
            case exit:
                System.exit(0);
                break;
        }
        return result;
    }
}
