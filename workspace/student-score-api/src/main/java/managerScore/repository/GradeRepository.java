package managerScore.repository;


import managerScore.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, String> {

    Grade findByStudentId(String studentId);

}
