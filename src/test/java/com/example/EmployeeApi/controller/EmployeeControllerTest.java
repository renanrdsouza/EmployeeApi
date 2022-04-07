package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.EmployeeApiApplication;
import com.example.EmployeeApi.model.Department;
import com.example.EmployeeApi.model.Employee;
import com.example.EmployeeApi.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeApiApplication.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void deveriaRetornarListaDeEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @BeforeEach
    public void setup() {
        Employee e1 = new Employee("Renan", 2000.0, new Department(1L, "TI"));
        Employee e2 = new Employee("João", 2000.0, new Department(1L, "TI"));

        List<Employee> employeeList = Arrays.asList(e1, e2);

        Mockito.when(service.listAll(1, 2, "id", "ASC")).thenReturn((Page<Employee>) employeeList);
    }
}
