package com.example.EmployeeApi.service;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto detail(Long id) {
        return new EmployeeDto(employeeRepository.getById(id));
    }

    public List<EmployeeDto> listAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }
}
