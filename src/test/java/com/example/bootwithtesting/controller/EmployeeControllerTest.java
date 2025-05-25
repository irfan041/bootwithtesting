package com.example.bootwithtesting.controller;

import com.example.bootwithtesting.model.Employee;
import com.example.bootwithtesting.model.Movie;
import com.example.bootwithtesting.service.EmployeeService;
import com.example.bootwithtesting.service.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;
    @Mock
    private EmployeeService employeeService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(employeeController)
                .setControllerAdvice().build();
        this.objectMapper=new ObjectMapper();
    }

    @Test
    public void testControllerForCreateMovie() throws Exception{
        this.mockMvc.perform(
                post("/api/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getEmployee()))
                        .accept(MediaType.APPLICATION_JSON)

        ).andExpect(status().isOk());
        verify(employeeService).save(any(Employee.class));
    }

    private Employee getEmployee(){
        return Employee.builder()
                .email("asaas")
                .id(1)
                .name("sasas")
                .build();
    }
}
