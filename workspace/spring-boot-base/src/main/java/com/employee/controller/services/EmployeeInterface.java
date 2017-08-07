package com.employee.controller.services;

import com.employee.controller.model.Address;
import com.employee.controller.model.Employee;

import java.util.ArrayList;

public interface EmployeeInterface {

    Boolean addEmployee(Employee employee);

    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Boolean updateEmployeeById(int id, Employee employee);

    Boolean deleteEmployeeById(int id);

    ArrayList<Address> getEmployeeAddress(int id);
}
