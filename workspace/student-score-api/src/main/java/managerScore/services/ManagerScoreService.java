package managerScore.services;

import managerScore.models.Report;
import managerScore.models.Student;

import java.util.List;

public interface ManagerScoreService {

    String return_add_student_info_when_input_1(String input);
    String return_student_score_and_info_when_input_2(String input);

    List<Student> addStudent(Student student);
    Report getReport(String id);

}
