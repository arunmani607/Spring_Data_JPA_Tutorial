package com.example.spring_data_jpa_tutorial;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee_task")
public class EmployeeTaskController {

    @Autowired
    public EmplyeeService emplyeeService;

    @PostMapping("/insertTask")
    public ResponseEntity<EmployeeTaskDetails> savingEmpTaskDtls(@Valid @RequestBody EmployeeTaskDetails taskDtls) {

        try {
            EmployeeTaskDetails saveTask = emplyeeService.saveEmployeeTaskDetails(taskDtls);
            return ResponseEntity.ok(saveTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
