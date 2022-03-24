package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.dto.NewEmployeeDto;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.repository.DepartmentRepository;
import com.example.EmployeeApi.repository.EmployeeRepository;
import com.example.EmployeeApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> detail(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.detail(id));
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> list (@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "24") Integer size,
                                                   @RequestParam(value = "sort", defaultValue = "id") String sort,
                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction
                                                   ){
        Page<Employee> employees = employeeService.listAll(page, size, sort, direction);
        Page<EmployeeDto> employeeDtos = employees.map(EmployeeDto::new);

        return ResponseEntity.ok().body(employeeDtos);
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody NewEmployeeDto newEmployeeDto) {
        Employee employee = employeeService.fromDto(newEmployeeDto);
        employee = employeeService.insert(employee);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody NewEmployeeDto newEmployeeDto) {
        Employee employeeAtualizado = employeeService.fromDto(newEmployeeDto);

        return ResponseEntity.ok().body(employeeService.update(id ,employeeAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
