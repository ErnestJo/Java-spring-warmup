package com.example.springWarmup.service;

import com.example.springWarmup.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>  getAllEmployees();
}
