package com.example.EmployeeManagementSystem.Repository.Secondary;



//Exercise3
import com.example.EmployeeManagementSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

//Exercise 8

import com.example.EmployeeManagementSystem.Projection.DepartmentProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  
	@Query("SELECT d FROM Department d WHERE d.id = :departmentId")
  DepartmentProjection findDepartmentByIdProjection(@Param("departmentId") Long departmentId);
}

