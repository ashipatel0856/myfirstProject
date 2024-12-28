package com.ashi.springBootWebTutorial.Controller;
import com.ashi.springBootWebTutorial.Dto.EmployeeDto;
import com.ashi.springBootWebTutorial.Entity.EmployeeEntity;
import com.ashi.springBootWebTutorial.Repository.EmployeeRepository;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/Employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")

    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);

    }


    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }


    @PostMapping

    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);


    }


    @PutMapping

    public String updateEmployee() {
        return "hello from put";
    }
}
