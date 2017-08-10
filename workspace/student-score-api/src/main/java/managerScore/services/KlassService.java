package managerScore.services;

import managerScore.models.Grade;
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

    Student getStudentById(String id);

    void saveStudentGrade(Grade grade);

    Grade getGradeByStudentId(String studentId);

    List<Grade> getGrades();

    void updateGradeByStudentId(String id, Grade newGrade);

    void deleteGradeByStudentId(String studentId);
}
