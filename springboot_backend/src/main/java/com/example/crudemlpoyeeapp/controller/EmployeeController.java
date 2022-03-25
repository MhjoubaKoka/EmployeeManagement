package com.example.crudemlpoyeeapp.controller;

import com.example.crudemlpoyeeapp.exception.ResourceNotFoundException;
import com.example.crudemlpoyeeapp.model.Employee;
import com.example.crudemlpoyeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id :"+id));
        return ResponseEntity.ok(employee);
    }

    //update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee updatedemployee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id :"+id));
        updatedemployee.setFirstName(employee.getFirstName());
        updatedemployee.setLastName(employee.getLastName());
        updatedemployee.setEmailId(employee.getEmailId());
        return ResponseEntity.ok(employeeRepository.save(updatedemployee));
    }

    //delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id :"+id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
