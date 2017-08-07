package managerScore.servicesImpl;

import managerScore.models.Klass;
import managerScore.models.Student;
import managerScore.services.KlassService;
import managerScore.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private Klass klass = new Klass();

    public int getStudentTotalScore(Student student) {
        return Integer.parseInt(student.getMath()) + Integer.parseInt(student.getLanguage())
                + Integer.parseInt(student.getEnglish()) + Integer.parseInt(student.getProgram());
    }
}
