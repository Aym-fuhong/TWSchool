package com.student.services;

import com.student.model.Employee;

import java.util.ArrayList;

public interface EmployeeInterface {

    Boolean addEmployee(Employee employee);

    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Boolean updateEmployeeById(int id, Employee employee);

    Boolean deleteEmployeeById(int id);
}
