package com.student.services;

import com.student.model.Employee;

import java.util.ArrayList;

public interface EmployeeInterface {

    Employee addEmployee(Employee employee);

    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Employee updateEmployeeById(int id, Employee employee);

    Boolean deleteEmployeeById(int id);
}
