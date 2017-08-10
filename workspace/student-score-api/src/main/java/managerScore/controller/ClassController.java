package managerScore.controller;

import managerScore.models.Grade;
import managerScore.models.Student;
import managerScore.services.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClassController {

    @Autowired
    private KlassService klassService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public HttpStatus saveStudent(@RequestBody Student student) {
        klassService.saveStudent(student);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentArrayList = klassService.findAllStudent();
        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = klassService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentId}/grades", method = RequestMethod.POST)
    public HttpStatus saveGradeByStudentId(@PathVariable String studentId, @RequestBody Grade grade) {
        Student student = klassService.getStudentById(studentId);
        if (student == null) {
            return HttpStatus.NOT_FOUND;
        } else {
            Grade existGrade = klassService.getGradeByStudentId(studentId);
            Grade newGrade = new Grade(studentId, grade.getMath(), grade.getLanguage(),
                    grade.getEnglish(), grade.getProgram());
            if (existGrade == null) {
                klassService.saveStudentGrade(newGrade);
            } else {
                System.out.println("int ohere==========");
                klassService.updateGradeByStudentId(studentId, newGrade);
            }
            return HttpStatus.OK;
        }
    }

    @RequestMapping(value = "/students/{studentId}/grades", method = RequestMethod.GET)
    public ResponseEntity<Grade> getGradeByStudentId(@PathVariable String studentId) {
        Grade grade = klassService.getGradeByStudentId(studentId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/grades", method = RequestMethod.GET)
    public ResponseEntity<List<Grade>> getGrades() {
        List<Grade> gradeList = klassService.getGrades();
        return new ResponseEntity<>(gradeList, HttpStatus.OK);
    }

    //    @RequestMapping(value = "/students", method = RequestMethod.POST)
//    public ResponseEntity<List> addStudent(@RequestBody Student student) {
//        List<Student> studentList = managerScoreService.addStudent(student);
//        return new ResponseEntity<>(studentList, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    public ResponseEntity<ArrayList<Student>> getAllStudent() {
//        ArrayList<Student> studentArrayList = managerScoreService.getAllStudentList();
//        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
//    public ResponseEntity<ArrayList<Student>> getStudentById(@PathVariable String id) {
//        ArrayList<Student> studentArrayList = managerScoreService.getStudentById(id);
//        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
//    }
}
