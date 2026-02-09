package com.example.spring_data_jpa_tutorial;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTaskRepository extends JpaRepository<EmployeeTaskDetails,Integer> {
    
}
