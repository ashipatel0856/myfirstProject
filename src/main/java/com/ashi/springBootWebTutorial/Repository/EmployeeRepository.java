package com.ashi.springBootWebTutorial.Repository;

import com.ashi.springBootWebTutorial.Dto.EmployeeDto;
import com.ashi.springBootWebTutorial.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {



}
