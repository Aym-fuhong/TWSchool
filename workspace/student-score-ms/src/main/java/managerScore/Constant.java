package managerScore;

public class Constant {
    private String menuString = "1. 添加学生 \n" +
            "2. 生成成绩单 \n" +
            "3. 退出 \n" +
            "请输入你的选择（1～3) :";
    private String addStudentBegining = "请输入学生信息";
    private String addStudentFormat = "（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交";
    private String errString = "请按正确的格式输入";
    private String studentIdPrompt = "输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交:";
    private String studentScoreString = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n" +
            "========================\n" +
            "小明|99|88|100|99|96.5|386\n" +
            "========================\n" +
            "全班总平均分：386.0\n" +
            "全班总分中位数：386.0\n";
    private String noStudentScoreString = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n" +
            "========================\n" +
            "========================\n" +
            "全班总平均分：0.0\n" +
            "全班总分中位数：0.0\n";

    public String getMenuString() {
        return menuString;
    }

    public String getAddStudentBegining() {
        return addStudentBegining;
    }

    public String getAddStudentFormat() {
        return addStudentFormat;
    }

    public String getErrString() {
        return errString;
    }

    public String getStudentIdPrompt() {
        return studentIdPrompt;
    }

    public String getStudentScoreString() {
        return studentScoreString;
    }

    public String getNoStudentScoreString() {
        return noStudentScoreString;
    }
}
