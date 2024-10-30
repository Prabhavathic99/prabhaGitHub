package net.javaguides.department_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // create param for the fields included
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDesc(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDesc(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDesc(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
