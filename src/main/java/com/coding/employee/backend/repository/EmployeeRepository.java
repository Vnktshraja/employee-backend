package com.coding.employee.backend.repository;

import com.coding.employee.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByMail(String mail);

    @Query("SELECT e FROM Employee e where e.city in :cityLists")
    List<Employee> findByListOfCity(@Param("cityLists") List<String> cityLists);

    List<Employee> findByCity(String city);
}
