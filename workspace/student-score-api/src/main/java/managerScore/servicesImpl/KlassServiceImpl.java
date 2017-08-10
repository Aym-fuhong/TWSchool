package managerScore.servicesImpl;

import managerScore.IOFilter;
import managerScore.models.Grade;
import managerScore.models.Klass;
import managerScore.models.Student;
import managerScore.repository.GradeRepository;
import managerScore.repository.StudentRepository;
import managerScore.services.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KlassServiceImpl implements KlassService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    Klass klass = new Klass();

    @Override
    public Klass createKlass() {
        return klass;
    }

    @Override
    public List<Student> findAllStudent() {
        List studentArrayList = studentRepository.findAll();
        return studentArrayList;
    }

    @Override
    public Student getStudentById(String id) {
        Student student = studentRepository.findById(id);
        return student;
    }

    @Override
    public void saveStudentGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public Grade getGradeByStudentId(String studentId) {
        return gradeRepository.findByStudentId(studentId);

    }

    @Override
    public List<Grade> getGrades() {
        List<Grade> gradeList = gradeRepository.findAll();
        return gradeList;
    }

    @Override
    public void updateGradeByStudentId(String studentId, Grade newGrade) {
        System.out.println("+++=+++++++++");
        deleteGradeByStudentId(studentId);
        saveStudentGrade(newGrade);
    }

    @Override
    public void deleteGradeByStudentId(String studentId) {
        gradeRepository.delete(studentId);
    }


    public void saveStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> addStudentInfo(Student student) {
        int id = klass.getAddStudentInfoList().size();
        student.setId(Integer.toString(id + 1));
        klass.getAddStudentInfoList().add(student);
        return klass.getAddStudentInfoList();
    }


    public ArrayList<Student> getAllStudentList() {
        return (ArrayList<Student>) klass.getAddStudentInfoList();
    }

    public ArrayList<Student> getStudentList(String id) {
        String[] splitedIds = IOFilter.getStudentsId(id);
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < splitedIds.length; i++) {
            if (findOne(splitedIds[i], (ArrayList<Student>) klass.getAddStudentInfoList()) != null) {
                Student student = findOne(splitedIds[i], (ArrayList<Student>) klass.getAddStudentInfoList());
                list.add(student);
            }
        }
        return list;
    }

    public Student findOne(String element, ArrayList<Student> collection) {
        Object result = null;
        for (Student item : collection) {
            if (item.getId().equals(element.trim())) {
                result = item;
            }
        }
        return (Student) result;
    }

}
