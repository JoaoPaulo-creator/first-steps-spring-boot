package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements EmployeeInterface {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> show() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> store(@RequestBody Employee employee) {
        return validateEmployee(employee).map(validateEmployee -> employeeRepository.save(validateEmployee));
    }

    private Optional<Employee> validateEmployee(Employee employee) {
        return Optional.ofNullable(employee)
                .filter(e -> e.getName() != null) // fitrando somente os diferentes de null
                .map(Optional::of)
                .orElseThrow(() -> new IllegalArgumentException("name is required")); // se o filtro encontrar algo
                                                                                      // diferente de nao null, entao
                                                                                      // sera retornado uma exeception
    }

    @Override
    public Optional<Employee> index(UUID id) {
        return employeeRepository.findById(id);
    }
}
