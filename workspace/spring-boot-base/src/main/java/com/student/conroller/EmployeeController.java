package com.student.conroller;

import com.student.model.Employee;
import com.student.services.EmployeeInterface;
import com.student.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeInterface employeeInterface = new EmployeeService();

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id) {
        Employee e = employeeInterface.getEmployeeById(id);
        return e;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ArrayList<Employee> getEmployees() {
        return employeeInterface.getEmployees();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeInterface.updateEmployeeById(id, employee);
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteEmployee(@PathVariable("id") int id) {
        if (employeeInterface.deleteEmployeeById(id)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
