package com.example.spring_data_jpa_tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplyeeService {
  @Autowired
  public EmployeeDetailsRepository employeeDetailsRepository;

  public  EmployeeInfo toSaveEmployeeInfo(EmployeeInfo employee){
      return employeeDetailsRepository.save(employee);
  }

  public List<EmployeeInfo>getEmployeeInfos(){
      return employeeDetailsRepository.findAll();
  }

  public EmployeeInfo updateEmployeeInfo(Integer id,EmployeeInfo employeeInfo){
      EmployeeInfo update=employeeDetailsRepository.findById(id)
              .orElseThrow(()->new RuntimeException("Employee not found::::"+id));
      update.setEmployeeAge(employeeInfo.getEmployeeAge());
      update.setEmployeeDesign(employeeInfo.getEmployeeDesign());
      update.setEmployeeName(employeeInfo.getEmployeeName());
      update.setEmployeeMobNo(employeeInfo.getEmployeeMobNo());
      update.setEmployeeGmail(employeeInfo.getEmployeeGmail());

      return employeeDetailsRepository.save(update);
  }
}
