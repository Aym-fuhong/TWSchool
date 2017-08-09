package managerScore.models;

import java.util.ArrayList;
import java.util.List;


public class Klass {

    private String id;
    private List<Student> addStudentInfoList = new ArrayList<>();

    public List<Student> getAddStudentInfoList() {
        return addStudentInfoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


