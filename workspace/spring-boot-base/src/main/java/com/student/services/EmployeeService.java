package com.student.services;

import com.student.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService implements EmployeeInterface {

    private ArrayList<Employee> employeeList = new ArrayList<>();

    @Override
    public ArrayList<Employee> getEmployees() {
        Employee e1 = new Employee(1, "而通过", 2);
        Employee e2 = new Employee(2, "而规划", 2);
        employeeList.add(e1);
        employeeList.add(e2);
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
    public Boolean addEmployee(Employee employee) {
        employeeList.add(employee);
        return true;
    }


    @Override
    public Boolean updateEmployeeById(int id, Employee employee) {
        Employee e = new Employee(1, "而通过", 2);
        employeeList.add(e);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(employeeList.get(i));
                employeeList.add(employee);
                return true;
            }
        }
        return false;
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
