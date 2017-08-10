package managerScore.controller;

import managerScore.models.Student;
import managerScore.services.KlassService;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ClassController {

    @Autowired
    private KlassService klassService;

    //    @RequestMapping(value = "/students", method = RequestMethod.POST)
//    public ResponseEntity<List> addStudent(@RequestBody Student student) {
//        List<Student> studentList = managerScoreService.addStudent(student);
//        return new ResponseEntity<>(studentList, HttpStatus.CREATED);
//    }
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
