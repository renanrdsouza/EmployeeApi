package com.example.EmployeeApi;

import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.repository.DepartmentRepository;
import com.example.EmployeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class EmployeeApiApplication {

//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Autowired
//	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Department department = new Department("TI");
//
//		Employee employee = new Employee("Renan", 2700.0, department);
//
//		department.getEmployees().addAll(Arrays.asList(employee));
//		employee.setDepartment(department);
//
//		departmentRepository.save(department);
//		employeeRepository.save(employee);
//	}
}