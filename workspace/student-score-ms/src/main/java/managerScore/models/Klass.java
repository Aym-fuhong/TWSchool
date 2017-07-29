package managerScore.models;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private List<Student> addStudentInfoList = new ArrayList<>();
    private List<Student> searchStudentInfoList = new ArrayList<>();

    public List<Student> getAddStudentInfoList() {
        return addStudentInfoList;
    }

    public List<Student> getSearchStudentInfoList() {
        return searchStudentInfoList;
    }

//    public List<Student> addStudentInfo(String input) {
//        String[] infoList = input.trim().split("，");
//        this.addStudentInfoList.add(new Student(infoList[0], infoList[1], infoList[2].split("：")[1],
//                infoList[3].split("：")[1], infoList[4].split("：")[1], infoList[5].split("：")[1]));
//        return addStudentInfoList;
//    }
//
//    public ArrayList<Student> getStudentList(String input) {
//        String[] splitedIds = input.trim().split("，");
//        for (int i = 0; i < splitedIds.length; i++) {
//            if (findOne(splitedIds[i], (ArrayList<Student>) this.addStudentInfoList) != null) {
//                Student student = findOne(splitedIds[i], (ArrayList<Student>) this.addStudentInfoList);
//                this.searchStudentInfoList.add(student);
//            }
//        }
//        return (ArrayList<Student>) this.searchStudentInfoList;
//    }
//
//    public float getAverageOfClass() {
//        int result = 0;
//        final int[] totalScore = {0};
//        if (this.searchStudentInfoList.size() > 0) {
//            searchStudentInfoList.forEach(student ->
//                    totalScore[0] += student.getStudentTotalScore()
//            );
//            result = totalScore[0] / this.searchStudentInfoList.size();
//        }
//        return (float) result;
//    }
//
//    public float getMedianOfClass() {
//        int result = 0;
//        List<Student> medianScoreList = new ArrayList<>();
//        if (this.searchStudentInfoList.size() > 0) {
//            medianScoreList = this.searchStudentInfoList.stream()
//                    .sorted((student1, student2) -> student1.getStudentTotalScore() - student2.getStudentTotalScore())
//                    .collect(Collectors.toList());
//            result = this.getMedian(medianScoreList);
//        }
//        return (float) result;
//    }
//
//    private int getMedian(List<Student> list) {
//        int median = 0;
//        int i = list.size() / 2;
//        if (list.size() % 2 == 0) {
//            median = (list.get(i).getStudentTotalScore() + list.get(i - 1).getStudentTotalScore()) / 2;
//        } else {
//            median = list.get(i).getStudentTotalScore();
//        }
//        return median;
//    }
//
//    private Student findOne(String element, ArrayList<Student> collection) {
//        Object result = null;
//        for (Student item : collection) {
//            if (item.getId().equals(element.trim())) {
//                result = item;
//            }
//        }
//        return (Student) result;
//    }


}
