package com.example.EmployeeApi.dto;

import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double salary;
    private Department department;

    public EmployeeDto() {

    }

    public EmployeeDto(Employee employee) {
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.department = employee.getDepartment();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
