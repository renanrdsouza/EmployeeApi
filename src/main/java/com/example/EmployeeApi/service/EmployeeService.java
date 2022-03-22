package com.example.EmployeeApi.service;

import com.example.EmployeeApi.dto.EmployeeDto;
import com.example.EmployeeApi.dto.NewEmployeeDto;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.repository.DepartmentRepository;
import com.example.EmployeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeDto detail(Long id) {
        return new EmployeeDto(employeeRepository.findById(id).get());
    }

    public Page<Employee> listAll(int page, int size, String sort, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), sort);

        return employeeRepository.findAll(pageRequest);
    }

    @Transactional
    public Employee insert(Employee employee) {
        employee = employeeRepository.save(employee);
        departmentRepository.save(employee.getDepartment());
        return employee;
    }

    public EmployeeDto update(Long id, Employee employeeAtualizado) {
        Employee employee = employeeRepository.findById(id).get();

        updateEmployee(employeeAtualizado, employee);

        employeeRepository.save(employee);

        return new EmployeeDto(employee);
    }

    public ResponseEntity delete(Long id) {
        employeeRepository.deleteById(id);

        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    private void updateEmployee(Employee employeeAtualizado, Employee employee) {
        employee.setName(employeeAtualizado.getName());
        employee.setSalary(employeeAtualizado.getSalary());
        employee.setDepartment(employeeAtualizado.getDepartment());
    }

    public Employee fromDto(NewEmployeeDto newEmployeeDto) {
        Department department = departmentRepository.findById(newEmployeeDto.getDepartmentId()).get();
        Employee employee = new Employee(newEmployeeDto.getName(), newEmployeeDto.getSalary(), department);

        return employee;
    }
}
