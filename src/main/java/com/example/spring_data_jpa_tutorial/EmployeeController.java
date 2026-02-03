package com.example.spring_data_jpa_tutorial;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Pattern;


import java.util.List;

@RestController
@RequestMapping("/employeeData")
public class EmployeeController {

    @Autowired
    public EmplyeeService epmService;

    @PostMapping("/savedata")
    public EmployeeInfo save(@Valid @RequestBody EmployeeInfo employeeInfo)
    {
        return epmService.toSaveEmployeeInfo(employeeInfo);
    }

    @GetMapping("/getAllData")
    public List<EmployeeInfo> getEmployeeInfoList(EmployeeInfo employeeInfo){
        return epmService.getEmployeeInfos();
    }

    @PutMapping("/{id}")
    public EmployeeInfo updateEmployeeDts(@PathVariable Integer id,
                                          @Valid @RequestBody EmployeeInfo employeeInfo){
        return  epmService.updateEmployeeInfo(id,employeeInfo);
    }


    @GetMapping("/{selectedUserId}")
    public EmployeeInfo particularUserId(@PathVariable  Integer selectedUserId){
        return epmService.findTheParticularId(selectedUserId);
    }

    @GetMapping("/deleting/{deleteid}")
    public String toDeleteEmployeeDetails(@PathVariable Integer deleteid){
         epmService.deleting_the_user(deleteid);
         return  "Employee Id is deleted successfully for "+deleteid;
    }
}
