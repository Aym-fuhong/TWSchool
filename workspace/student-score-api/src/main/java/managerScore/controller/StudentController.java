package managerScore.controller;

import managerScore.models.Student;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<List> addStudent(@RequestBody Student student) {
        List<Student> studentList = managerScoreService.addStudent(student);
        return new ResponseEntity<List>(studentList, HttpStatus.CREATED);
    }
}
