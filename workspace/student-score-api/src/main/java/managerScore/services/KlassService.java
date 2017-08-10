package managerScore.services;

import managerScore.models.Klass;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;


public interface KlassService {
    void saveStudent(Student student);
    List<Student> addStudentInfo(Student student);
    ArrayList<Student> getStudentList(String input);
    Student findOne(String element, ArrayList<Student> collection);
    ArrayList<Student> getAllStudentList();
    Klass createKlass();
    List<Student> findAllStudent();
}
