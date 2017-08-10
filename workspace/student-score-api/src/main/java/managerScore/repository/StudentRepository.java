package managerScore.repository;


import managerScore.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student,String>{

    Student findById(String id);
//    List<Student> findAll();
}
