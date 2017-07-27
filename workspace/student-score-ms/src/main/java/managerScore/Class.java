package managerScore;

import java.util.ArrayList;


public class Class {
    private ArrayList<Student> studentInfoList;

    public ArrayList<Student> addStudentInfo(String input) {
        String[] infoList = input.trim().split("，");
        this.studentInfoList.add(new Student(infoList[0], infoList[1], infoList[2].split("：")[1],
                infoList[3].split("：")[1], infoList[4].split("：")[1], infoList[5].split("：")[1]));
        return studentInfoList;
    }

    public ArrayList<Student> getStudentList(String input) {
        String[] splitedIds = input.trim().split("，");
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < splitedIds.length; i++) {
            if (findOne(splitedIds[i], Constant.studentInfoList) != null) {
                Student student = findOne(splitedIds[i], Constant.studentInfoList);
                studentList.add(student);
            }
        }
        return studentList;
    }

    private Student findOne(String element, ArrayList<Student> collection) {
        Object result = null;
        for (Student item : collection) {
            if (item.getId().equals(element.trim())) {
                result = item;
            }
        }
        return (Student) result;
    }
}
