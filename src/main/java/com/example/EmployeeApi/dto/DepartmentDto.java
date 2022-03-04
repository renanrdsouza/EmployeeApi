package com.example.EmployeeApi.dto;

import com.example.EmployeeApi.model.Department;

public class DepartmentDto {

    private String name;

    public DepartmentDto(Department department) {
        this.name = department.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
