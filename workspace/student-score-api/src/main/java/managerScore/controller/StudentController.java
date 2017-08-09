package managerScore.controller;

import managerScore.models.Grade;
import managerScore.models.Student;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class StudentController {
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/grades", method = RequestMethod.POST)
    public Grade addStudent(@RequestBody Grade grade) {
        return null;
    }

}
