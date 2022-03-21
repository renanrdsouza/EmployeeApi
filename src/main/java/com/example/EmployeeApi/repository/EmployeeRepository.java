package com.example.EmployeeApi.repository;

import com.example.EmployeeApi.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findByDepartmentName(String deparmentName, Pageable paginacao);

}
