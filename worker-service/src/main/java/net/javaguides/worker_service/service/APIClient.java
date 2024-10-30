package net.javaguides.worker_service.service;

import net.javaguides.worker_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);

}
