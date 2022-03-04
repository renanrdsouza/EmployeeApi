package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.dto.DepartmentDto;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartmentDto> detail(@PathVariable Long id) {

        return ResponseEntity.ok().body(departmentService.detail(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> listAll() {
        return ResponseEntity.ok().body(departmentService.listAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Department> insert(@RequestBody @Valid Department department) {

        departmentService.save(department);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/new")
                .buildAndExpand(department.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department updatedDepartment) {

        return ResponseEntity.ok().body(departmentService.update(id, updatedDepartment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        departmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
