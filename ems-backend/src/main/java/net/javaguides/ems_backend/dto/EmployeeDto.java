package net.javaguides.ems_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    @NotEmpty(message = "employee first name should not be empty")
    private String firstName;
    private String lastName;
    @NotEmpty(message = "employee should add mail id")
    @Email(message = "mail is not in format")
    private String email;
    private int age;
    private Long salary;
}
