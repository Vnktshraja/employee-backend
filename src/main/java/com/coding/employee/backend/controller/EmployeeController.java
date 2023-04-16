package com.coding.employee.backend.controller;


import com.coding.employee.backend.entity.Employee;
import com.coding.employee.backend.repository.EmployeeRepository;
import com.coding.employee.backend.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String login(){
        return "Authenticated and Logged in Successfully....!";
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee){
        log.info("Entered addEmployee() method of EmployeeController class");
        employeeService.addEmployee(employee);
        Optional<Employee> emp = employeeRepository.findById(employee.getId());
        if(emp!=null)
            return new ResponseEntity<>("Employee "+employee.getId()+" saved successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Employee "+employee.getId()+" Not saved in database", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/emp")
    public void addListOfEmp(@RequestBody List<Employee> employee){
        employeeService.addListOfEmp(employee);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        log.info("Entered into getAllEmployee() Method of EmployeeController class");
        List<Employee> employees =  employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Employee> getByEmailId(@PathVariable String mail){
        log.info("Entered into getByEmailId() Method of EmployeeController class");
        Employee employee = employeeService.getByEmail(mail);
        return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable Long id){
        log.info("Entered into deleteEmployee() Method of EmployeeController class");
        List<Employee> employee = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/gcity/{city}")
    public List<Employee> getEmpOfcity(@PathVariable("city") List<String> cityLists){
        System.out.println(cityLists);
        log.info("getlist of city",cityLists);
        return  employeeService.getEmpOfcity(cityLists);
    }

//    @GetMapping("/get/{city}")
//    public List<Employee> getCity(@PathVariable String city){
//        log.info("enter controller to get city",city);
//        List<Employee> e2 = employeeService.getCity(city);
//        return e2;
//    }
}
