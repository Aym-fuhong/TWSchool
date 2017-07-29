package managerScore;

import managerScore.managerScoreServices.Stat;

public class InputFilter {

    private String dealString;

    public void setDealString(String dealString) {
        this.dealString = dealString;
    }

    public String getDealString() {
        return dealString;
    }

    public void dealInput(String input) {
        if (input != null) {
            if (input.trim().matches("[123]")) {
                this.setDealString(input);
            }
        }
    }
}
