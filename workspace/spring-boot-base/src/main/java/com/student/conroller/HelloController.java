package com.student.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> string() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
}