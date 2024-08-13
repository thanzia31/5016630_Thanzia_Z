package com.example.EmployeeManagementSystem.Projection;

//Exercise 8

//Class based projection


public class EmployeeDTO {
    private String name;
    private String email;

    
    public EmployeeDTO(String name, String email) {
        this.name = name;
        this.email = email;
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
}

