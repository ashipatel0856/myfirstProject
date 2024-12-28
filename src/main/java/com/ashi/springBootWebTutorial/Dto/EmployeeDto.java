package com.ashi.springBootWebTutorial.Dto;

import java.time.LocalDate;

public class EmployeeDto {
    private long id;
    private String name;
    private String email;
    private Integer age;

    private LocalDate dateOfJoining;

    private Boolean isActive;

    public EmployeeDto(long employeeId, String ashish, String mail, int i, LocalDate of, boolean b) {
    }


//
//
//    public EmployeeDto(String employeeID, String ashish, String mail, int i, LocalDate of, Boolean b) {
//
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
