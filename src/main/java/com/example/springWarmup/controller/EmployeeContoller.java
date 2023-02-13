package com.example.springWarmup.controller;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.example.springWarmup.model.Employee;
import com.example.springWarmup.repository.EmployeeRepository;
import com.example.springWarmup.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeContoller {
    private EmployeeService employeeService;

    public EmployeeContoller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

}
