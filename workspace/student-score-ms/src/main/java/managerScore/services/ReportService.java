package managerScore.services;

import managerScore.IOFilter;
import managerScore.interfaces.ReportInterface;
import managerScore.models.Report;

public class ReportService implements ReportInterface {

    public String getStudentScoreString(Report report) {
        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n";
        for (int i = 0; i < report.getStudentList().size(); i++) {
            result += new IOFilter().formatString(report.getStudentList().get(i));
        }
        result += "========================\n" +
                "全班总平均分：" + report.getAverageOfClass() + "\n" +
                "全班总分中位数：" + report.getMedianOfClass() + "\n";
        return result;

    }
}
