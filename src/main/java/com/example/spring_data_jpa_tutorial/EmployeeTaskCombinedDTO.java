package com.example.spring_data_jpa_tutorial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaskCombinedDTO {

    private Integer employeeId;
    private String employeeName;
    private String employeeDesign;
    private String employeeMobNo;
    private Integer employeeAge;
    private String employeeGmail;
    private List<TaskDTO> tasks;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TaskDTO {
        private Long taskReferenceId;
        private String empTaskid;
        private String empTaskDesciption;
        private String empTaskPriority;
        private String empTaskStatus;
    }

}
