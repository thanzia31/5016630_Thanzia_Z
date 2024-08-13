package com.example.EmployeeManagementSystem.Repository.Primary;


//Exercise3 
import com.example.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//Exercise 5 Starts
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//Exercise 5 Ends

//Exercise6
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;
//Exercise  8

import com.example.EmployeeManagementSystem.Projection.EmployeeDTO;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 
  
	//Exercise5
	
	//Exercise 8
	 // Derived query methods with pagination returning DTO
  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.name = :name")
  Page<EmployeeDTO> findByName(@Param("name") String name, Pageable pageable);

  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
  Page<EmployeeDTO> findByDepartmentId(@Param("departmentId") Long departmentId, Pageable pageable);

  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.email = :email")
  Page<EmployeeDTO> findByEmail(@Param("email") String email, Pageable pageable);

  // Custom queries using @Query annotation with pagination returning DTO
  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.name = :name")
  Page<EmployeeDTO> findEmployeesByNameCustom(@Param("name") String name, Pageable pageable);

  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
  Page<EmployeeDTO> findEmployeesByDepartmentIdCustom(@Param("departmentId") Long departmentId, Pageable pageable);

  @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.email = :email")
  Page<EmployeeDTO> findEmployeeByEmailCustom(@Param("email") String email, Pageable pageable);
  
  // Named queries with pagination returning DTO
  @Query(name = "Employee.findByName", value = "SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.name = :name")
  Page<EmployeeDTO> findEmployeesByNameNamed(@Param("name") String name, Pageable pageable);

  @Query(name = "Employee.findByDepartmentId", value = "SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
  Page<EmployeeDTO> findEmployeesByDepartmentIdNamed(@Param("departmentId") Long departmentId, Pageable pageable);

  @Query(name = "Employee.findByEmail", value = "SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.email = :email")
  Page<EmployeeDTO> findEmployeeByEmailNamed(@Param("email") String email, Pageable pageable);
}
