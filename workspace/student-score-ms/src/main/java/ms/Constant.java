package ms;

/**
 * Created by Hong on 26/07/2017.
 */
public class Constant {
    private String menuString = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出";
    private String addStudentPromptString = "请输入学生信息" +
            "（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交";

    public String getMenuString() {
        return menuString;
    }

    public String getAddStudentPromptString() {
        return addStudentPromptString;
    }
}
