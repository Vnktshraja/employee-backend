package com.coding.employee.backend.service;

import com.coding.employee.backend.entity.Employee;
import com.coding.employee.backend.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{@Autowired

    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee){
        log.info("Entered into addEmployee() method of EmployeeService class");
        Employee e = employeeRepository.save(employee);
        System.out.println(e);
    }

    public void addListOfEmp(List<Employee> employee){
        List<Employee> emp = employee;
        employeeRepository.saveAll(emp);
    }
    @Override
    public List<Employee> getEmpOfcity(List<String> cityLists) {
        log.info("entered into service",cityLists);
        List<Employee> emp = employeeRepository.findByListOfCity(cityLists);
        log.info("service end");
        return emp;
    }

//    @Override
//    public List<Employee> getCity(String city) {
//        List<Employee> e3 = employeeRepository.findByCity(city);
//        return e3;
//    }

    @Override
    public List<Employee> getAllEmployee() {
        log.info("Entered into getAllEmployee() method of EmployeeService class");
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getByEmail(String mail) {
        log.info("Entered into getByEmail() method of EmployeeService class");
        Employee emp = employeeRepository.findByMail(mail);
        return emp;
    }

    @Override
    public List<Employee> deleteEmployeeById(Long id) {
        log.info("Entered into deleteEmployeeById() method of EmployeeService class");
        employeeRepository.deleteById(id);
        log.info("Employee"+id+"deleted from the database successfully");
        return employeeRepository.findAll();
    }


}
