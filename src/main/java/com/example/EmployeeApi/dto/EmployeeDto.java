package com.example.EmployeeApi.dto;

import com.example.EmployeeApi.model.Employee;

public class EmployeeDto {

    private String name;
    private Double salary;
    private DepartmentDto departmentDto;

    public EmployeeDto(Employee employee) {
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.departmentDto = new DepartmentDto(employee.getDepartment());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
