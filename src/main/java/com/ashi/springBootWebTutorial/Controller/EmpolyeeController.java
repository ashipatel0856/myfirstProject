package com.ashi.springBootWebTutorial.Controller;

import com.ashi.springBootWebTutorial.Dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;

@RestController
@RequestMapping(path="/Employees")
public class EmpolyeeController {
//
//    @GetMapping(path="/message")
//    public String getmysecretmessage(){
//        return "secret message";
//    }

    @GetMapping("/{employeeId}")

    public EmployeeDto getEmployeeById(@PathVariable(name="employeeId") Long id) {
        return new EmployeeDto(id,"ashish","ashishkumarr0856@gmail.com",20, LocalDate.of(2024 ,1 ,2),true);

    }


    @GetMapping
    public String getEmployees(@RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String sortBy) {
        return "hi age"+age+" "+sortBy;
    }



    @PostMapping

    public  String createNewEmployee(@RequestBody EmployeeDto inputemployee) {
        inputemployee.setId(100);
        return "success";

    }


    @PutMapping

    public  String updateEmployee() {
        return "hello from put";
    }
}
