package com.example.spring_data_jpa_tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmplyeeService {
  @Autowired
  public EmployeeDetailsRepository employeeDetailsRepository;
  @Autowired
  public EmployeeTaskRepository employeeTaskRepository;

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

  public EmployeeInfo findTheParticularId(Integer id){
      return employeeDetailsRepository.findById(id)
              .orElseThrow(() -> new RuntimeException(
                      "Employee not found with id " + id));
  }

  public void  deleting_the_user (Integer id){
      if(employeeDetailsRepository.existsById(id)){
          employeeDetailsRepository.deleteById(id);
      }else {
        throw new RuntimeException("Employee Id is not found :::"+id);
      }

    }
    public List<EmployeeInfo> findingEmployeeDesign(String employeeInfo){
      List<EmployeeInfo>searchDesign=employeeDetailsRepository.findByEmployeeDesign(employeeInfo);
      return  searchDesign;

    }

    public List<EmployeeInfo>findingAgeListOFEmployee(Integer age) throws Exception {
      List<EmployeeInfo>employeeAges=employeeDetailsRepository.findByemployeeAge(age);
        if (employeeAges.isEmpty()) {
            throw new Exception(
                    "No employees found with age: " + age);
        }
      return employeeAges;
    }


    public EmployeeTaskDetails saveEmployeeTaskDetails(EmployeeTaskDetails taskDetails){
      return employeeTaskRepository.save(taskDetails);
    }
    
    // Combined method: Get all employees with their tasks
    public List<EmployeeTaskCombinedDTO> getAllEmployeesWithTasks() {
        List<EmployeeInfo> employees = employeeDetailsRepository.findAll();
        
        return employees.stream().map(employee -> {
            EmployeeTaskCombinedDTO dto = new EmployeeTaskCombinedDTO();
            dto.setEmployeeId(employee.getEmployeeId());
            dto.setEmployeeName(employee.getEmployeeName());
            dto.setEmployeeDesign(employee.getEmployeeDesign());
            dto.setEmployeeMobNo(employee.getEmployeeMobNo());
            dto.setEmployeeAge(employee.getEmployeeAge());
            dto.setEmployeeGmail(employee.getEmployeeGmail());
            
            // Fetch tasks for this employee
            List<EmployeeTaskDetails> tasks = employeeTaskRepository.findTasksByEmployeeId(employee.getEmployeeId());
            
            if (tasks != null && !tasks.isEmpty()) {
                List<EmployeeTaskCombinedDTO.TaskDTO> taskDTOs = tasks.stream()
                    .map(task -> new EmployeeTaskCombinedDTO.TaskDTO(
                        task.getEmployeeSeqid(),
                        task.getEmpTaskid(),
                        task.getEmpTaskDesciption(),
                        task.getEmpTaskPriority().toString(),
                        task.getEmpTaskStatus().toString()
                    ))
                    .collect(Collectors.toList());
                dto.setTasks(taskDTOs);
            } else {
                dto.setTasks(Collections.emptyList());
            }
            
            return dto;
        }).collect(Collectors.toList());
    }
    
    // Combined method: Get specific employee with tasks
    public EmployeeTaskCombinedDTO getEmployeeWithTasksById(Integer employeeId) {
        EmployeeInfo employee = employeeDetailsRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        
        EmployeeTaskCombinedDTO dto = new EmployeeTaskCombinedDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmployeeDesign(employee.getEmployeeDesign());
        dto.setEmployeeMobNo(employee.getEmployeeMobNo());
        dto.setEmployeeAge(employee.getEmployeeAge());
        dto.setEmployeeGmail(employee.getEmployeeGmail());
        
        List<EmployeeTaskDetails> tasks = employeeTaskRepository.findTasksByEmployeeId(employeeId);
        
        if (tasks != null && !tasks.isEmpty()) {
            List<EmployeeTaskCombinedDTO.TaskDTO> taskDTOs = tasks.stream()
                .map(task -> new EmployeeTaskCombinedDTO.TaskDTO(
                    task.getEmployeeSeqid(),
                    task.getEmpTaskid(),
                    task.getEmpTaskDesciption(),
                    task.getEmpTaskPriority().toString(),
                    task.getEmpTaskStatus().toString()
                ))
                .collect(Collectors.toList());
            dto.setTasks(taskDTOs);
        } else {
            dto.setTasks(Collections.emptyList());
        }
        
        return dto;
    }
}
