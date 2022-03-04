package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> detail(@PathVariable Long id) {

        return ResponseEntity.ok().body(employeeService.detail(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> listAll() {
        return ResponseEntity.ok().body(employeeService.listAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> insert(@Valid @RequestBody Employee employee) {

        employeeService.save(employee);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/new")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {

        return ResponseEntity.ok().body(employeeService.update(id, employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
