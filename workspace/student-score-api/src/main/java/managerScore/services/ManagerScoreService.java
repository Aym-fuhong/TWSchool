package managerScore.services;

import managerScore.models.Report;
import managerScore.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ManagerScoreService {

    List<Student> addStudent(Student student);

    Report getAllReport();

    ArrayList<Student> getAllStudentList();

    ArrayList<Student> getStudentById(String id);
}
