package managerScore.controller;

import managerScore.models.Student;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class ClassController {
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> getAllReport() {
        ArrayList<Student> studentArrayList = managerScoreService.getAllStudentList();
        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> getStudentById(@PathVariable String id) {
        ArrayList<Student> studentArrayList = managerScoreService.getStudentById(id);
        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);

    }
}
