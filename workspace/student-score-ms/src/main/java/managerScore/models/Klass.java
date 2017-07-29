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

    public void setSearchStudentInfoList(ArrayList<Student> searchStudentInfoList) {
        this.searchStudentInfoList = searchStudentInfoList;
    }
}
