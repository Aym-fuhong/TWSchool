package managerScore;

import java.util.ArrayList;
import java.util.List;

public class ManagerScore {
    private Constant constant = new Constant();
    private Class klass = new Class();
    private String dealString;

    public Class getKlass() {
        return klass;
    }

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
            result = this.return_add_student_info_when_input_1(input);
            this.setDealString("");
        } else if ("2".equals(this.getDealString())) {
            result = constant.getStudentIdPrompt();
            this.setDealString("2-*");
        } else if ("2-*".equals(this.getDealString())) {
            result = this.return_student_score_and_info_when_input_2(input);
            this.setDealString("");
        }
        return result;
    }

    private String return_add_student_info_when_input_1(String input) {
        String result = constant.getErrString() + constant.getAddStudentFormat();
        if (Util.formatOneInput(input)) {
            List<Student> studentInfoList = klass.addStudentInfo(input);
            result = "学生" + studentInfoList.get(0).getName() + "的成绩被添加\n" + constant.getMenuString();
        }
        return result;
    }

    private String return_student_score_and_info_when_input_2(String input) {
        String result = constant.getErrString() + constant.getStudentIdPrompt();
        if (Util.formatTwoInput(input)) {
            ArrayList<Student> studentList = klass.getStudentList(input);
            result = this.getStudentScoreString(studentList) + constant.getMenuString();
        }
        return result;
    }

    private String getStudentScoreString(ArrayList<Student> studentList) {
        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n";
        for (int i = 0; i < studentList.size(); i++) {
            result += Util.formatString(studentList.get(i));
        }
        result += "========================\n" +
                "全班总平均分：xxx\n" +
                "全班总分中位数：xxx\n";
        System.out.println(result);
        return result;

    }

}
