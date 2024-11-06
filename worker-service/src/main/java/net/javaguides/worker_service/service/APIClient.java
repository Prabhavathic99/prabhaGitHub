package net.javaguides.worker_service.service;

import net.javaguides.worker_service.dto.DepartmentDto;
import net.javaguides.worker_service.dto.OrganisationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface APIClient {

    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);

    /*@GetMapping("api/organisations/{organisationCode}")
    OrganisationDto getOrganisationByCode(@PathVariable String organisationCode);*/
}