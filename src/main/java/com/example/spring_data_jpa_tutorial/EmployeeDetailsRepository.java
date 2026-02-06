package com.example.spring_data_jpa_tutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeInfo,Integer> {
    List<EmployeeInfo>findByEmployeeDesign(String design);
    List<EmployeeInfo>findByemployeeAge(Integer age);
}
