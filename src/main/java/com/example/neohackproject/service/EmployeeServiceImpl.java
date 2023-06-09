package com.example.neohackproject.service;

import com.example.neohackproject.model.Credential;
import com.example.neohackproject.model.Employee;
import com.example.neohackproject.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee chekCredentialsEmployee(Credential credential) {
        List<Employee> list = employeeRepository.findAll();
        for (Employee p : list) {
            if (p.getLogin().equals(credential.getLogin()) && p.getPassword().equals(credential.getPassword())) {
                return p;
            }
        }
        return null;
    }
}
