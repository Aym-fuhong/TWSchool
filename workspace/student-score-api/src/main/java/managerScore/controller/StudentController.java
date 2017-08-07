package managerScore.controller;

import managerScore.models.Student;
import managerScore.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<List> addStudent(@RequestBody Student student) {
        List<Student> studentList = studentService.addStudent(student);
        return new ResponseEntity<List>(studentList, HttpStatus.CREATED);
    }
}
