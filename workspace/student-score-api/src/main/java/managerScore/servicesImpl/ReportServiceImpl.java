package managerScore.servicesImpl;

import managerScore.IOFilter;
import managerScore.models.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements managerScore.services.ReportService {

    public StringBuffer getStudentScoreString(Report report) {
        StringBuffer sb = new StringBuffer();
        sb.append("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");
        for (int i = 0; i < report.getStudentList().size(); i++) {
            sb.append(new IOFilter().formatString(report.getStudentList().get(i)));
        }
        sb.append("========================\n全班总平均分：");
        sb.append(report.getAverageOfClass());
        sb.append("\n全班总分中位数：");
        sb.append(report.getMedianOfClass());
        return sb;
    }
}
