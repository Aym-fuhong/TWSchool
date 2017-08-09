package managerScore.servicesImpl;

import managerScore.IOFilter;
import managerScore.services.KlassService;
import managerScore.models.Klass;
import managerScore.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KlassServiceImpl implements KlassService {
    Klass klass = new Klass();

    @Override
    public Klass createKlass() {
        return klass;
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
