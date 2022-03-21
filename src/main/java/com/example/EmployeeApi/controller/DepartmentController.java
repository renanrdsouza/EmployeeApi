package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.dto.DepartmentDto;
import com.example.EmployeeApi.dto.NewDepartmentDto;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> listAll() {
        return ResponseEntity.ok().body(departmentService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> detail(@PathVariable Long id) {
        return ResponseEntity.ok().body(departmentService.detail(id));
    }

    @PostMapping
    public ResponseEntity<Department> insert(@RequestBody NewDepartmentDto NewDepartmentDto) {
        Department department = departmentService.fromDto(NewDepartmentDto);

        department = departmentService.insert(department);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(department.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable Long id, @RequestBody NewDepartmentDto newDepartmentDto) {
        return ResponseEntity.ok().body(departmentService.update(id, newDepartmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        departmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
