package com.example.EmployeeManagementSystem.Service;

//Exercise4

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Projection.EmployeeDTO;
import com.example.EmployeeManagementSystem.Repository.Primary.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//Exercise6

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

    public Page<EmployeeDTO> getEmployeesByName(String name, Pageable pageable) {
        return employeeRepository.findByName(name, pageable);
    }

    public Page<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    public Page<EmployeeDTO> getEmployeesByEmail(String email, Pageable pageable) {
        return employeeRepository.findByEmail(email, pageable);
    }
    
    // Custom queries
    public Page<EmployeeDTO> getEmployeesByNameCustom(String name, Pageable pageable) {
        return employeeRepository.findEmployeesByNameCustom(name, pageable);
    }

    public Page<EmployeeDTO> getEmployeesByDepartmentIdCustom(Long departmentId, Pageable pageable) {
        return employeeRepository.findEmployeesByDepartmentIdCustom(departmentId, pageable);
    }

    public Page<EmployeeDTO> getEmployeeByEmailCustom(String email, Pageable pageable) {
        return employeeRepository.findEmployeeByEmailCustom(email, pageable);
    }

    // Named queries
    public Page<EmployeeDTO> getEmployeesByNameNamed(String name, Pageable pageable) {
        return employeeRepository.findEmployeesByNameNamed(name, pageable);
    }

    public Page<EmployeeDTO> getEmployeesByDepartmentIdNamed(Long departmentId, Pageable pageable) {
        return employeeRepository.findEmployeesByDepartmentIdNamed(departmentId, pageable);
    }

    public Page<EmployeeDTO> getEmployeeByEmailNamed(String email, Pageable pageable) {
        return employeeRepository.findEmployeeByEmailNamed(email, pageable);
    }
    
}
