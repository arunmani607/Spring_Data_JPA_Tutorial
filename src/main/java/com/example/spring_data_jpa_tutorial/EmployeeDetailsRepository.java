package com.example.spring_data_jpa_tutorial;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeInfo,Integer> {
}
