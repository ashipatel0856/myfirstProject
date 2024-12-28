package com.ashi.springBootWebTutorial.Controller;
import com.ashi.springBootWebTutorial.Dto.EmployeeDto;
import com.ashi.springBootWebTutorial.Entity.EmployeeEntity;
import com.ashi.springBootWebTutorial.Repository.EmployeeRepository;


import com.ashi.springBootWebTutorial.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/Employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")

    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);

    }


    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping

    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.save(employee);


    }


    @PutMapping

    public String updateEmployee() {
        return "hello from put";
    }
}
