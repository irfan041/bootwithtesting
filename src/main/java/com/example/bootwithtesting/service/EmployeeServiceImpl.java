package com.example.bootwithtesting.service;

import com.example.bootwithtesting.model.Employee;
import com.example.bootwithtesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public Employee save(Employee employee) {
        return null;
    }
}
