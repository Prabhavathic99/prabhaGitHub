package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ems")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Add new employee
    @PostMapping("new")
    public ResponseEntity<EmployeeDto> createNewEmployeeDetail(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    // Get Employee Detail by id
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeDetailByEmployeeId(@PathVariable("empId") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    // Get all Employee Details
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> retrieveAllEmployee(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }
}
