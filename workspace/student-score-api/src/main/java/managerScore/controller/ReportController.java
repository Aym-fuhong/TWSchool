package managerScore.controller;

import managerScore.models.Report;
import managerScore.services.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/report/{id}", method = RequestMethod.GET)
    public ResponseEntity<Report> printReport(@PathVariable String id) {
        Report report = managerScoreService.getReport(id);
        return new ResponseEntity<Report>(report, HttpStatus.OK);
    }
}
