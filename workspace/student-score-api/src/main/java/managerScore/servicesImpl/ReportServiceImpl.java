package managerScore.servicesImpl;

import managerScore.models.Klass;
import managerScore.models.ReportItem;
import managerScore.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements managerScore.services.ReportService {

    public ArrayList<ReportItem> getReportItem(Klass klass){
       ArrayList<ReportItem> reportItemArrayList = new ArrayList<>();
        List<Student> studentList = klass.getAddStudentInfoList();
        for(int i=0; i< studentList.size(); i++){
            int totalScore = getStudentTotalScore(studentList.get(i));
            int averageScore = getStudentAverageScore(studentList.get(i));
            ReportItem reportItem = new ReportItem(studentList.get(i), totalScore, averageScore);
            System.out.println(reportItem);
            reportItemArrayList.add(reportItem);
        }
        return reportItemArrayList;
    }

    public float getAverageOfClass(Klass klass) {
        int result = 0;
        final int[] totalScore = {0};
        if (klass.getAddStudentInfoList().size() > 0) {
            klass.getAddStudentInfoList().forEach(student ->
                    totalScore[0] += getStudentTotalScore(student)
            );
            result = totalScore[0] / klass.getAddStudentInfoList().size();
        }
        return (float) result;
    }

    public float getMedianOfClass(Klass klass) {
        int result = 0;
        List<Student> medianScoreList = new ArrayList<>();
        if (klass.getAddStudentInfoList().size() > 0) {
            medianScoreList = klass.getAddStudentInfoList().stream()
                    .sorted((student1, student2) -> getStudentTotalScore(student1)
                            - getStudentTotalScore(student2))
                    .collect(Collectors.toList());
            result = this.getMedian(medianScoreList);
        }
        return (float) result;
    }

    public int getMedian(List<Student> list) {
        int median = 0;
        int i = list.size() / 2;
        if (list.size() % 2 == 0) {
            median = (getStudentTotalScore(list.get(i))
                    + getStudentTotalScore(list.get(i - 1))) / 2;
        } else {
            median = getStudentTotalScore(list.get(i));
        }
        return median;
    }

    public int getStudentTotalScore(Student student) {
        return Integer.parseInt(student.getMath()) + Integer.parseInt(student.getLanguage())
                + Integer.parseInt(student.getEnglish()) + Integer.parseInt(student.getProgram());
    }

    @Override
    public int getStudentAverageScore(Student student) {
        return getStudentTotalScore(student) / 4;
    }
}
