package ms;

import java.util.ArrayList;

public class Constant {
    private String menuString = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出";
    private String addStudentBegining = "请输入学生信息";
    private String addStudentFormat = "（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交";
    private String errString = "请按正确的格式输入";
    private String studentIdPrompt = "输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交:";
    public static ArrayList<Student> studentInfoList = new ArrayList<Student>();

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
}
