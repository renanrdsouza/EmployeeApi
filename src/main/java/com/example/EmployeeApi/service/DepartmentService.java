package com.example.EmployeeApi.service;

import com.example.EmployeeApi.dto.DepartmentDto;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentDto detail(Long id) {
        Department department = departmentRepository.getById(id);

        if(department == null) {
            throw new EntityNotFoundException("Não encontrado.");
        }

        return new DepartmentDto(department);
    }
    
    public List<DepartmentDto> listAll() {

        return departmentRepository
                .findAll()
                .stream()
                .map(DepartmentDto::new)
                .collect(Collectors.toList());
    }

    public Department save(Department department) {
        List<Department> departments = departmentRepository.findAll();

        return departmentRepository.save(department);
    }

    public Department update(Long id, Department updatedDepartment) {
        Department department = departmentRepository.getById(id);

        if(department == null) {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }

        update(department, updatedDepartment);

        return department;
    }

    public void update(Department department, Department updatedDepartment) {
        department.setName(updatedDepartment.getName());
    }

    public ResponseEntity delete(Long id) {
        return departmentRepository.findById(id)
                .map(department -> {
                    departmentRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
