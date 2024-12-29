package com.ashi.springBootWebTutorial.Dto;


import com.ashi.springBootWebTutorial.Annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    @Size(min = 3, max = 10, message = "number of characters in name should be in the range:[3,10]")
    private String name;


    @NotBlank(message = "email of employee can not be blank")
    @Email(message = "email should be a valid email")
    private String email;


    @NotBlank(message = "age of employee can not be blank here")
    @Max(value = 50, message = "age can not be greater than 50")
    @Min(value = 18,message = "age can not be less than 18")
    private Integer age;

    @NotNull(message = " salary of employee should be not null")
    @Positive(message = "salary of employee should be positive")
    @Digits(integer = 8,fraction = 2, message = "the salary can be in the from xxxx.yy")
    @DecimalMax(value="11101000.88")
    @DecimalMin(value = "1000000.99")
    private Double salary;

    @NotBlank(message = "role of employee can not be blank")
    //@Pattern(regexp = "^(ADMIN/USER)$",message = "role of employee can be user or admin")
    @EmployeeRoleValidation
    private String role;



    @PastOrPresent(message = "date of joining field employee can not be in the future")
    private LocalDate dateOfJoining;


    @AssertTrue(message = "employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;



//    public EmployeeDto(long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//
//
//    }

}
