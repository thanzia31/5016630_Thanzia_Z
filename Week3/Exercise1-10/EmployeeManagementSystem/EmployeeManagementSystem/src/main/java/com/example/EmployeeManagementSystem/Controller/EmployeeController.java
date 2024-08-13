package com.example.EmployeeManagementSystem.Controller;

//Exercise4
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Projection.EmployeeDTO;
import com.example.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Exercise6

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/by-name")
    public Page<EmployeeDTO> getEmployeesByName(
            @RequestParam String name, 
            Pageable pageable) {
        return employeeService.getEmployeesByName(name, pageable);
    }

    @GetMapping("/by-department")
    public Page<EmployeeDTO> getEmployeesByDepartmentId(
            @RequestParam Long departmentId, 
            Pageable pageable) {
        return employeeService.getEmployeesByDepartmentId(departmentId, pageable);
    }

    @GetMapping("/by-email")
    public Page<EmployeeDTO> getEmployeesByEmail(
            @RequestParam String email, 
            Pageable pageable) {
        return employeeService.getEmployeesByEmail(email, pageable);
    }
    
    // Custom queries
    @GetMapping("/custom/by-name")
    public Page<EmployeeDTO> getEmployeesByNameCustom(
            @RequestParam String name, 
            Pageable pageable) {
        return employeeService.getEmployeesByNameCustom(name, pageable);
    }

    @GetMapping("/custom/by-department")
    public Page<EmployeeDTO> getEmployeesByDepartmentIdCustom(
            @RequestParam Long departmentId, 
            Pageable pageable) {
        return employeeService.getEmployeesByDepartmentIdCustom(departmentId, pageable);
    }

    @GetMapping("/custom/by-email")
    public Page<EmployeeDTO> getEmployeeByEmailCustom(
            @RequestParam String email, 
            Pageable pageable) {
        return employeeService.getEmployeeByEmailCustom(email, pageable);
    }

    // Named queries
    @GetMapping("/named/by-name")
    public Page<EmployeeDTO> getEmployeesByNameNamed(
            @RequestParam String name, 
            Pageable pageable) {
        return employeeService.getEmployeesByNameNamed(name, pageable);
    }

    @GetMapping("/named/by-department")
    public Page<EmployeeDTO> getEmployeesByDepartmentIdNamed(
            @RequestParam Long departmentId, 
            Pageable pageable) {
        return employeeService.getEmployeesByDepartmentIdNamed(departmentId, pageable);
    }

    @GetMapping("/named/by-email")
    public Page<EmployeeDTO> getEmployeeByEmailNamed(
            @RequestParam String email, 
            Pageable pageable) {
        return employeeService.getEmployeeByEmailNamed(email, pageable);
    }
}
