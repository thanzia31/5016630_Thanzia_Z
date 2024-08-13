package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Repository.Secondary.DepartmentRepository;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

	

	    @Autowired
	    @Qualifier("entityManagerFactory")
	    private EntityManagerFactory entityManagerFactory;

	    @Autowired
	    private DepartmentRepository departmentRepository;

	    public Department saveDepartment(Department department) {
	        return departmentRepository.save(department);
	    }

	    public Optional<Department> findById(Long id) {
	        return departmentRepository.findById(id);
	    }

	    public List<Department> findAllDepartments() {
	        return departmentRepository.findAll();
	    }

	    public void deleteDepartmentById(Long id) {
	        departmentRepository.deleteById(id);
	    }
	}


