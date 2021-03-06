package com.example.EmployeeApi.repository;

import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void deveriaRetornarAListaDeTodosEmployeesCadastrados() {
        Employee employee = new Employee("Renan", 2500.0, new Department(1L, "TI"));
        List<Employee> employees = employeeRepository.findAll();
        employees.add(employee);

        for (Employee e:employees) {
            System.out.println(e);
        }

        Assertions.assertFalse(employees.isEmpty());
    }
}
