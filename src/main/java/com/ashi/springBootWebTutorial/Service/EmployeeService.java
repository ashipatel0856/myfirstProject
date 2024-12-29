package com.ashi.springBootWebTutorial.Service;

import com.ashi.springBootWebTutorial.Dto.EmployeeDto;
import com.ashi.springBootWebTutorial.Entity.EmployeeEntity;
import com.ashi.springBootWebTutorial.Exceptions.ResourceNotFoundException;
import com.ashi.springBootWebTutorial.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final  EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    public Optional<EmployeeDto> getEmployeeById(Long id) {

//        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        return employeeRepository.findById(id).map(employeeEntity ->modelMapper.map(employeeEntity, EmployeeDto.class));


    }

    public  List<EmployeeDto> getAllEmployees() {
            List<EmployeeEntity> employeeEntity = employeeRepository.findAll();

            return employeeEntity
                    .stream()
                    .map(EmployeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                    .collect(Collectors.toList());

    }



    public EmployeeDto createNewEmployee(EmployeeDto employeeEntity) {
        EmployeeEntity toSaveEntity=modelMapper.map(employeeEntity, EmployeeEntity.class);
        EmployeeEntity savedemployeeEntity = employeeRepository.save(toSaveEntity);

        return modelMapper.map(savedemployeeEntity, EmployeeDto.class);

    }

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {

        boolean exists=employeeRepository.existsById(employeeId);
        if(!exists) throw new ResourceNotFoundException("employee not found with id "+employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDto.class);

    }


    public boolean isExistingEmployeeById(Long employeeId) {
//        return employeeRepository.findById(employeeId).isPresent(); or
        return employeeRepository.existsById(employeeId);
    }
    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists=employeeRepository.existsById(employeeId);
        if(!exists)
            return false;
            employeeRepository.deleteById(employeeId);
            return true;


    }

    public EmployeeDto updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {

        boolean exists=employeeRepository.existsById(employeeId);
        if(!exists)
            return null;
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);

        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);
    }


}
