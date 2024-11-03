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

        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDesc(),
                savedDepartment.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department newDepartment = new Department();
        try{
            newDepartment = departmentRepository.findByDepartmentCode(departmentCode);
        } catch (Exception e){
            System.out.println("error123"+e.getMessage());
        }
        return new DepartmentDto(
                newDepartment.getId(),
                newDepartment.getDepartmentName(),
                newDepartment.getDepartmentDesc(),
                newDepartment.getDepartmentCode()
        );
    }
}
