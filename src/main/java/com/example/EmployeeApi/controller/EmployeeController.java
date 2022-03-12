package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<EmployeeDto> detail(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.detail(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> listAll() {
        return ResponseEntity.ok().body(employeeService.listAll());
    }

}
