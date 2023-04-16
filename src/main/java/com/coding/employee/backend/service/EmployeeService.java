package com.coding.employee.backend.service;

import com.coding.employee.backend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getByEmail(String mail);

    List<Employee> deleteEmployeeById(Long id);

    void addListOfEmp(List<Employee> employee);

    List<Employee> getEmpOfcity(List<String> cityLists);

//    List<Employee> getEmpOfcity(String city);
}
