package com.ashi.springBootWebTutorial.Controller;
import com.ashi.springBootWebTutorial.Dto.EmployeeDto;


import com.ashi.springBootWebTutorial.Exceptions.ResourceNotFoundException;
import com.ashi.springBootWebTutorial.Service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/Employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")

    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employeeId") Long id) {

        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);

        return employeeDto
//                .map(ResponseEntity::ok)
                .map(employeeDto1 -> new ResponseEntity<>(employeeDto1, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));

    }







    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee) {
        EmployeeDto savedemployeeDto = employeeService.createNewEmployee(inputEmployee);

        return new ResponseEntity<>(savedemployeeDto, HttpStatus.CREATED);


    }


    @PutMapping(path="/{employeeId}")

    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody @Valid EmployeeDto employeeDto, @PathVariable(name = "employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDto));


    }


    @DeleteMapping(path ="/{employeeId}")

    public  ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "employeeId") Long employeeId) {
       boolean gotDeletedById = employeeService.deleteEmployeeById(employeeId);
       if(gotDeletedById){
           return ResponseEntity.ok(true);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }


    @PatchMapping(path ="/{employeeId}")

    public ResponseEntity<EmployeeDto> updatePartialEmployeeById(@RequestBody Map<String,Object> updates,
                                                 @PathVariable Long employeeId) {

        EmployeeDto employeeDto = employeeService.updatePartialEmployeeById(employeeId,updates);
        if(employeeDto!=null){
            return ResponseEntity.ok(employeeDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
