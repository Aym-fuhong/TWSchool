package managerScore.services;

import managerScore.interfaces.KlassInterface;
import managerScore.interfaces.StudentInterface;
import managerScore.models.Klass;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KlassService implements KlassInterface {
    private StudentInterface studentInterface = new StudentService();

    public List<Student> addStudentInfo(Klass klass, String input) {
        String[] infoList = input.trim().split("，");
        klass.getAddStudentInfoList().add(new Student(infoList[0], infoList[1], infoList[2].split("：")[1],
                infoList[3].split("：")[1], infoList[4].split("：")[1], infoList[5].split("：")[1]));
        return klass.getAddStudentInfoList();
    }

    public ArrayList<Student> getStudentList(Klass klass, String input) {
        String[] splitedIds = input.trim().split("，");
        System.out.println(splitedIds.length);
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
        if (klass.getSearchStudentInfoList().size() > 0) {
            klass.getSearchStudentInfoList().forEach(student ->
                    totalScore[0] += studentInterface.getStudentTotalScore(student)
            );
            result = totalScore[0] / klass.getSearchStudentInfoList().size();
        }
        return (float) result;
    }

    public float getMedianOfClass(Klass klass) {
        int result = 0;
        List<Student> medianScoreList = new ArrayList<>();
        if (klass.getSearchStudentInfoList().size() > 0) {
            medianScoreList = klass.getSearchStudentInfoList().stream()
                    .sorted((student1, student2) -> studentInterface.getStudentTotalScore(student1)
                            - studentInterface.getStudentTotalScore(student2))
                    .collect(Collectors.toList());
            result = this.getMedian(medianScoreList);
        }
        return (float) result;
    }

    public int getMedian(List<Student> list) {
        int median = 0;
        int i = list.size() / 2;
        if (list.size() % 2 == 0) {
            median = (studentInterface.getStudentTotalScore(list.get(i))
                    + studentInterface.getStudentTotalScore(list.get(i - 1))) / 2;
        } else {
            median = studentInterface.getStudentTotalScore(list.get(i));
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
