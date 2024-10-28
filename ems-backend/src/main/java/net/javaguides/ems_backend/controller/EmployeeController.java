package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.exception.EmployeeNotFoundException;
import net.javaguides.ems_backend.exception.ErrorDetail;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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

    // Update the employee Details
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> modifyEmployeeDetail(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployeeDetail(id, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete the Employee
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }

    // custom exception handler by adding error details
    /*@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest req){
        ErrorDetail er = new ErrorDetail(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "EMPLOYEE_NOT_FOUND"
        );
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }*/
}