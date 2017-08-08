package managerScore.services;

import managerScore.models.Klass;
import managerScore.models.Report;
import managerScore.models.Student;

import java.util.ArrayList;
import java.util.List;

public interface ManagerScoreService {

    List<Student> addStudent(Student student);

    Report getAllReport();

    ArrayList<Student> getAllStudentList();
}
