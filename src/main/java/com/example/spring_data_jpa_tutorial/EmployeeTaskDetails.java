package com.example.spring_data_jpa_tutorial;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employee_Task")
@Getter
@Setter
public class EmployeeTaskDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long employeeSeqid;

    @NotNull(message = "Employee Task can't Empty")
    @Column(nullable = false, length = 7)
    @Size(min = 5, max = 7, message = "Employee Task id must have minimun 3 digits")
    public String empTaskid;

    @Column(nullable = false, length = 200)
    public String empTaskDesciption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    public PriorityEnum empTaskPriority = PriorityEnum.Low;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 12)
    public StatusEnum empTaskStatus = StatusEnum.InProgress;


    public enum PriorityEnum {
        Low, Medium, High
    }

    public enum StatusEnum {
        InProgress, Completed, Pending
    }
}
