package managerScore;

import java.util.ArrayList;

public class Report {
    private Class klass = new Class();

    public String getStudentScoreString(ArrayList<Student> studentList) {
        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n";
        for (int i = 0; i < studentList.size(); i++) {
            result += Util.formatString(studentList.get(i));
        }
        result += "========================\n" +
                "全班总平均分：" + klass.getAverageOfClass() + "\n" +
                "全班总分中位数：" + klass.getMedianOfClass() + "\n";
        System.out.println(result);
        return result;

    }
}
