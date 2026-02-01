package com.example.spring_data_jpa_tutorial;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "ETH_MA_EMPLOYEE_DETAILS")
public class EmployeeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer employeeId;

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @NotBlank(message = "Designation is required")
    private String employeeDesign;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Please enter a valid 10-digit mobile number"
    )
    private String employeeMobNo;

    @Min(value = 18, message = "Age must be above 18")
    @Max(value = 60, message = "Age must be below 60")
    private  Integer employeeAge;

    @Email(message = "Email required")
    private  String employeeGmail;

}
