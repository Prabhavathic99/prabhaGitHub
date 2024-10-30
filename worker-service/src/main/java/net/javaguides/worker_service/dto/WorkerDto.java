package net.javaguides.worker_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private String departmentCode;

}
