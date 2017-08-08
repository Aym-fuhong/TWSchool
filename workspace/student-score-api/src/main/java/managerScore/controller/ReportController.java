package managerScore.controller;

import managerScore.models.Report;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ReportController {
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public ResponseEntity<Report> getAllReport() {
        Report report = managerScoreService.getAllReport();
        return new ResponseEntity<Report>(report, HttpStatus.OK);
    }
}
