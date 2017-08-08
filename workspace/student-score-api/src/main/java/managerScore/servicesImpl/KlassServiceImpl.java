package managerScore.servicesImpl;

import managerScore.IOFilter;
import managerScore.services.KlassService;
import managerScore.services.StudentService;
import managerScore.models.Klass;
import managerScore.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KlassServiceImpl implements KlassService {
    @Autowired
    private StudentService studentService;

    public List<Student> addStudentInfo(Klass klass, Student student) {
        int id = klass.getAddStudentInfoList().size();
        student.setId(Integer.toString(id + 1));
        klass.getAddStudentInfoList().add(student);
        return klass.getAddStudentInfoList();
    }


    public ArrayList<Student> getAllStudentList(Klass klass) {
        return (ArrayList<Student>) klass.getAddStudentInfoList();
    }

    public ArrayList<Student> getStudentList(Klass klass, String id) {
        String[] splitedIds = IOFilter.getStudentsId(id);
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < splitedIds.length; i++) {
            if (findOne(splitedIds[i], (ArrayList<Student>) klass.getAddStudentInfoList()) != null) {
                Student student = findOne(splitedIds[i], (ArrayList<Student>) klass.getAddStudentInfoList());
                list.add(student);
            }
        }
        klass.setSearchStudentInfoList(list);
        return (ArrayList<Student>) klass.getSearchStudentInfoList();
    }

    public float getAverageOfClass(Klass klass) {
        int result = 0;
        final int[] totalScore = {0};
        if (klass.getAddStudentInfoList().size() > 0) {
            klass.getAddStudentInfoList().forEach(student ->
                    totalScore[0] += studentService.getStudentTotalScore(student)
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
                    .sorted((student1, student2) -> studentService.getStudentTotalScore(student1)
                            - studentService.getStudentTotalScore(student2))
                    .collect(Collectors.toList());
            result = this.getMedian(medianScoreList);
        }
        return (float) result;
    }

    public int getMedian(List<Student> list) {
        int median = 0;
        int i = list.size() / 2;
        if (list.size() % 2 == 0) {
            median = (studentService.getStudentTotalScore(list.get(i))
                    + studentService.getStudentTotalScore(list.get(i - 1))) / 2;
        } else {
            median = studentService.getStudentTotalScore(list.get(i));
        }
        return median;
    }

    public Student findOne(String element, ArrayList<Student> collection) {
        Object result = null;
        for (Student item : collection) {
            if (item.getId().equals(element.trim())) {
                result = item;
            }
        }
        return (Student) result;
    }

}
