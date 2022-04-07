package com.example.EmployeeApi.dto;

import javax.validation.constraints.NotBlank;

public class NewDepartmentDto {

    @NotBlank(message = "Preenchimento obrigatório")
    private String departmentName;

    public NewDepartmentDto() {

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
