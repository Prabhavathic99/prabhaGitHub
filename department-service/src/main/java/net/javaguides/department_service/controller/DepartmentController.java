package net.javaguides.department_service.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // save department
    @PostMapping("new")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto addedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(addedDepartmentDto, HttpStatus.CREATED);
    }

    // get department detail
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
