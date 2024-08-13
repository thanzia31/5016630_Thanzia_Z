package com.example.EmployeeManagementSystem.Projection;


//Exercise 8

//Interface based projection

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentProjection {

    @Value("#{target.name}")
    String getName();
}
