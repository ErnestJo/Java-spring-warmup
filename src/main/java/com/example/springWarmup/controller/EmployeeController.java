package com.example.springWarmup.controller;

import com.example.springWarmup.model.Employee;
import com.example.springWarmup.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get employee REST API
    @GetMapping()
    public List<Employee>  gerEmployee(){
        return employeeService.getAllEmployees();
    }

    // build get employee by ID REST API
    // http://localhost:8080/api/employee/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  long EmployeeId){
    return  new ResponseEntity<Employee>(employeeService.getSingleEmployee(EmployeeId), HttpStatus.OK);
    }


    // build update employee REST API
    // http://localhost:8080/api/employee/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  long id, @RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }

    // build update employee REST API
    // http://localhost:8080/api/employee/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
    employeeService.deleteEmployee(id);

    return new ResponseEntity<String>("Employee deleted successful!.", HttpStatus.OK);
    }
}
