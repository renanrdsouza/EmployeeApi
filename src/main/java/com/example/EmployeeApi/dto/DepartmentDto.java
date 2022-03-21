package com.example.EmployeeApi.dto;

import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDto implements Serializable {
    private static final long serialVersionUID = 1l;

    private String departmentName;
    private List<Employee> employees = new ArrayList<>();

    public DepartmentDto(Department department) {
        this.departmentName = department.getDepartmentName();
        this.employees.addAll(department.getEmployees());
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
