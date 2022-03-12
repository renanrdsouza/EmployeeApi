package com.example.EmployeeApi.dto;

public class DepartmentDto {

    private String departmentName;

    public DepartmentDto() {

    }

    public DepartmentDto(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
