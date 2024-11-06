package net.javaguides.worker_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    private WorkerDto workerDto;
    private DepartmentDto departmentDto;
    private OrganisationDto organisationDto;

}
