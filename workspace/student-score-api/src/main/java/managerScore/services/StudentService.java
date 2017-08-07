package managerScore.services;


import managerScore.models.Student;

import java.util.List;

public interface StudentService {
    int getStudentTotalScore(Student student);
    List<Student> addStudent(Student student);
}
