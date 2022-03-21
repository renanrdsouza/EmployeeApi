package com.example.EmployeeApi.dto;

import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.repository.DepartmentRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class NewEmployeeDto {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;

    @Min(1)
    private Double salary;
    private Long departmentId;

    public NewEmployeeDto() {

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}
