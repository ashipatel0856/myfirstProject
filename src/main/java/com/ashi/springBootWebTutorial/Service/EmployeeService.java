package com.ashi.springBootWebTutorial.Service;

import com.ashi.springBootWebTutorial.Entity.EmployeeEntity;
import com.ashi.springBootWebTutorial.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);

    }

    public List<EmployeeEntity> getAllEmployees() {
            return employeeRepository.findAll();
    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
}
