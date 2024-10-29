package net.javaguides.ems_backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(
        name = "CRUD REST APIs for Employee Resource",
        description = "CRUD REST APIs - Create Employee, Update Employee, Get Employee, Get All Employee, Delete Employee"
)
public class EmployeeController {

    private EmployeeService employeeService;

    // Add new employee
    @Operation(
            summary = "Create Employee REST API",
            description = "Create Employee REST API is used to save employee in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("new")
    public ResponseEntity<EmployeeDto> createNewEmployeeDetail(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    // Get Employee Detail by id
    @Operation(
            summary = "Get Employee By ID REST API",
            description = "Get Employee By ID REST API is used to get a single employee from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeDetailByEmployeeId(@PathVariable("empId") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    // Get all Employee Details
    @Operation(
            summary = "Get All Employees REST API",
            description = "Get All Employees REST API is used to get a all the employees from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> retrieveAllEmployee(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }

    // Update the employee Details
    @Operation(
            summary = "Update Employee REST API",
            description = "Update Employee REST API is used to update a particular employee in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> modifyEmployeeDetail(@PathVariable Long id, @RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployeeDetail(id, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete the Employee
    @Operation(
            summary = "Delete Employee REST API",
            description = "Delete Employee REST API is used to delete a particular employee from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }

    // custom exception handler by adding error details later moved to globalExceptionHandler
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
