package managerScore.models;

import java.util.ArrayList;

public class Report {
    private ArrayList<Student> studentList;
    private float averageOfClass;
    private float medianOfClass;

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public float getAverageOfClass() {
        return averageOfClass;
    }

    public float getMedianOfClass() {
        return medianOfClass;
    }

    public Report(ArrayList<Student> studentList, float averageOfClass, float medianOfClass) {
        this.studentList = studentList;
        this.averageOfClass = averageOfClass;
        this.medianOfClass = medianOfClass;
    }
}
