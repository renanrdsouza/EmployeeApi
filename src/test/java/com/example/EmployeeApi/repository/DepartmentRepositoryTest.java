package com.example.EmployeeApi.repository;

import com.example.EmployeeApi.model.Department;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void deveriaRetornarODepartamentoCorrespondenteAoNomePassadoComoParametro() {
        Department department = departmentRepository.findByDepartmentName("TI");
        String name = "TI";
        Assertions.assertNotNull(department);
        Assertions.assertEquals(department.getDepartmentName(), name);
    }
}
