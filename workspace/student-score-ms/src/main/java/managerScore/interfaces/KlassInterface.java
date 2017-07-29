package managerScore.interfaces;

import managerScore.models.Klass;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;


public interface KlassInterface {

    List<Student> addStudentInfo(Klass klass, String input);
    ArrayList<Student> getStudentList(Klass klass,String input);
    float getAverageOfClass(Klass klass);
    float getMedianOfClass(Klass klass);
    int getMedian(List<Student> list);
    Student findOne(String element, ArrayList<Student> collection);
}
