package com.example.EmployeeManagementSystem.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;




import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import org.hibernate.annotations.BatchSize;

//Exercise 7

import org.springframework.data.annotation.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@NoArgsConstructor
//Exercise 5
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByDepartmentId", query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
})
//Exercise 7
@EntityListeners(AuditingEntityListener.class)
//Exercise2 Starts
//Exercise 10
@BatchSize(size = 10)
public class Employee {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @ManyToOne
	    @JoinColumn(name = "department_id", nullable = false)
	    private Department department;
	    
	    //Exercise 7
	    @CreatedDate
	    @Column(name = "created_date", updatable = false)
	    private LocalDateTime createdDate;

	    @LastModifiedDate
	    @Column(name = "last_modified_date")
	    private LocalDateTime lastModifiedDate;
	    

	    @CreatedBy
	    @Column(name = "created_by")
	    private String createdBy;

	    @LastModifiedBy
	    @Column(name = "last_modified_by")
	    private String lastModifiedBy;
	    
	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    
	    public Department getDepartment() {
	        return department;
	    }

	    public void setDepartment(Department department) {
	        this.department = department;
	    }
	  //Exercise2 Ends
}



