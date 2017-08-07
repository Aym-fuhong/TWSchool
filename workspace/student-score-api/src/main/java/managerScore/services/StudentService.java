package managerScore.services;

import managerScore.interfaces.StudentInterface;
import managerScore.models.Student;

public class StudentService implements StudentInterface {
    public int getStudentTotalScore(Student student) {
        return Integer.parseInt(student.getMath()) + Integer.parseInt(student.getLanguage())
                + Integer.parseInt(student.getEnglish()) + Integer.parseInt(student.getProgram());
    }
}
