package com.example.bootwithtesting.controller;


import com.example.bootwithtesting.model.Employee;
import com.example.bootwithtesting.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
