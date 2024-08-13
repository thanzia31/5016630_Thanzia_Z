package com.example.EmployeeManagementSystem.Controller;

//Exercise4
import com.example.EmployeeManagementSystem.Entity.*;
import com.example.EmployeeManagementSystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	 @Autowired
	    private DepartmentService departmentService;

	    @PostMapping
	    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
	        Department savedDepartment = departmentService.saveDepartment(department);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
	        Optional<Department> department = departmentService.findById(id);
	        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    
	    @GetMapping
	    public ResponseEntity<List<Department>> getAllDepartments() {
	        List<Department> departments = departmentService.findAllDepartments();
	        return new ResponseEntity<>(departments, HttpStatus.OK);
	    }

	
	    @PutMapping("/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
	        Optional<Department> existingDepartment = departmentService.findById(id);
	        if (existingDepartment.isPresent()) {
	            department.setId(id);
	            Department updatedDepartment = departmentService.saveDepartment(department);
	            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	        }
	        return ResponseEntity.notFound().build();
	    }

	  
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        if (departmentService.findById(id).isPresent()) {
	            departmentService.deleteDepartmentById(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
}
