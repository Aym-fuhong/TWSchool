package managerScore.services;

import managerScore.models.Klass;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;


public interface KlassService {

    List<Student> addStudentInfo(Klass klass, Student student);
    ArrayList<Student> getStudentList(Klass klass,String input);
//    float getAverageOfClass(Klass klass);
//    float getMedianOfClass(Klass klass);
//    int getMedian(List<Student> list);
    Student findOne(String element, ArrayList<Student> collection);
    ArrayList<Student> getAllStudentList(Klass klass);
}
