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

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        for(int i=0; i< employeeList.size();i++){
            if(employeeList.get(i).getId() == id){
                return employeeList.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ArrayList<Employee> getEmployees() {
        return employeeList;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        Employee employee1 = employeeList.get(id);
        employee1.setAge(employee.getAge());
        employee1.setName(employee.getName());
        return employee1;
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteEmployee(@PathVariable("id") int id) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        for(int i=0; i< employeeList.size();i++){
            if(employeeList.get(i).getId() == id){
                employeeList.remove(employeeList.get(i));
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

}