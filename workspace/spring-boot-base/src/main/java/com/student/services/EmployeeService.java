package com.student.services;

import com.student.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService implements EmployeeInterface{

    private ArrayList<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public ArrayList<Employee> getEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        Employee employee1 = employeeList.get(id);
        employee1.setAge(employee.getAge());
        employee1.setName(employee.getName());
        return employee1;
    }

    @Override
    public Boolean deleteEmployeeById(int id) {
        Boolean flag = false;
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(employeeList.get(i));
                flag = true;
            }
        }
        return flag;

    }
}
