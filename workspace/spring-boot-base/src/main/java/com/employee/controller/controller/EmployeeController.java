package com.employee.controller.controller;

import com.employee.controller.model.Address;
import com.employee.controller.model.Employee;
import com.employee.controller.services.EmployeeInterface;
import com.employee.controller.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeInterface employeeInterface = new EmployeeService();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ArrayList> getEmployees() {
        ArrayList<Employee> employeeArrayList = employeeInterface.getEmployees();
        return new ResponseEntity<ArrayList>(employeeArrayList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee e = employeeInterface.getEmployeeById(id);
        return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpStatus addEmployee(@RequestBody Employee employee) {
        if (employeeInterface.addEmployee(employee)) {
            return HttpStatus.CREATED;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpStatus updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (employeeInterface.updateEmployeeById(id, employee)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteEmployee(@PathVariable("id") int id) {
        if (employeeInterface.deleteEmployeeById(id)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @RequestMapping(value = "/{id}/address", method = RequestMethod.GET)
    public ResponseEntity<ArrayList> getEmployeeAddress(@PathVariable("id")int id){
        ArrayList<Address> addressList = employeeInterface.getEmployeeAddress(id);
        return new ResponseEntity<ArrayList>(addressList, HttpStatus.OK);
    }

}
