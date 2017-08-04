package com.student.conroller;

import com.student.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HelloController {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> string() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setId(1);
        employeeList.add(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id")int id){
        Employee employee = employeeList.get(id);
        return employee;
    }
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ArrayList<Employee> getEmployees(){
        return employeeList;
    }

}