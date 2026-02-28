package com.example.spring_data_jpa_tutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeTaskRepository extends JpaRepository<EmployeeTaskDetails,Integer> {

    @Query("SELECT t FROM EmployeeTaskDetails t JOIN FETCH t.employee WHERE t.employee.employeeId = :employeeId")
    List<EmployeeTaskDetails> findTasksByEmployeeId(@Param("employeeId") Integer employeeId);

    @Query("SELECT t FROM EmployeeTaskDetails t JOIN FETCH t.employee")
    List<EmployeeTaskDetails> findAllTasksWithEmployees();
}
