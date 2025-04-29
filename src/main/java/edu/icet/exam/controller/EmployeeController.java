package edu.icet.exam.controller;

import edu.icet.exam.dto.Employee;
import edu.icet.exam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        boolean isAdd = employeeService.create(employee);
        return isAdd ? ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully"):ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create employee");
    }

    @PutMapping("/update")
    public ResponseEntity<String>updateEmployee(@RequestBody Employee employee){
        boolean isUpdated = employeeService.update(employee);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body("Employee updated successfully"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not found or unable to update");
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAll(){
        List<Employee> employeeList = employeeService.getAll();
        return employeeList!=null & !employeeList.isEmpty()?ResponseEntity.ok(employeeList):ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customers not found");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Employee>search(@PathVariable Long id){
        Employee searchedEmployee = employeeService.search(id);
        return searchedEmployee!=null ?ResponseEntity.ok(searchedEmployee):ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        boolean isDeleted = employeeService.delete(id);
        return isDeleted ? ResponseEntity.ok("Customer deleted Successfully"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not found");
    }

}
