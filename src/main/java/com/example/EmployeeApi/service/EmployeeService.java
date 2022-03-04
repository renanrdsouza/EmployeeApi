package com.example.EmployeeApi.service;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public EmployeeDto detail(Long id) {

        Employee employee = employeeRepository.getById(id);

        if(employee == null) {
            throw new EntityNotFoundException("Não encontrado");
        }

        return new EmployeeDto(employee);
    }

    public List<EmployeeDto> listAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Employee save(Employee employee) {
        employee.setId(null);
        employee = employeeRepository.save(employee);
        departmentService.save(employee.getDepartment());

        return employee;
    }

    public Employee update(Long id, Employee employeeAtualizado) {

        Employee employee = employeeRepository.findById(id).get();

        update(employee, employeeAtualizado);

        return employeeRepository.save(employee);
    }

    private void update(Employee employee, Employee employeeAtualizado) {
        employee.setName(employeeAtualizado.getName());
        employee.setSalary(employeeAtualizado.getSalary());
        employee.setDepartment(employeeAtualizado.getDepartment());
    }

    public ResponseEntity delete(Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
