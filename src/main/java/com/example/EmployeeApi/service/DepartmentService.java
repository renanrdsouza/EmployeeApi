package com.example.EmployeeApi.service;

import com.example.EmployeeApi.dto.DepartmentDto;
import com.example.EmployeeApi.dto.NewDepartmentDto;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<DepartmentDto> listAll() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentDto::new)
                .collect(Collectors.toList());
    }

    public DepartmentDto detail(Long id) {
        Department department = departmentRepository.findById(id).get();

        return new DepartmentDto(department);
    }

    public Department insert(Department department) {
        department.setId(null);

        department = departmentRepository.save(department);

        return department;
    }

    public DepartmentDto update(Long id, NewDepartmentDto newDepartmentDto) {
        Department department = departmentRepository.findById(id).get();

        updateDepartment(department, newDepartmentDto);

        departmentRepository.save(department);

        return new DepartmentDto(department);
    }

    public void delete(Long id) {
        departmentRepository.findById(id)
                .map(department -> {
                    departmentRepository.delete(department);
                    return ResponseEntity.ok().build();
                });
        ResponseEntity.notFound().build();
    }

    public Department fromDto(DepartmentDto departmentDto) {
        return new Department(null, departmentDto.getDepartmentName());
    }

    public Department fromDto(NewDepartmentDto newDepartmentDto) {
        return new Department(null, newDepartmentDto.getDepartmentName());
    }

    private void updateDepartment(Department department, NewDepartmentDto newDepartmentDto) {
        department.setDepartmentName(newDepartmentDto.getDepartmentName());
    }
}
