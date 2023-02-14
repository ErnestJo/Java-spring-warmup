package com.example.springWarmup.service;

import com.example.springWarmup.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>  getAllEmployees();
    Employee getSingleEmployee(long id);
    Employee updateEmployee(Employee employee, long id);
    void  deleteEmployee(long id);
}
