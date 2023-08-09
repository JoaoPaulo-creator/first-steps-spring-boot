package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.utils.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
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
    public Employee store(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> index(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> update(UUID id, Employee employee) {
        if (employee.getId() == null || !employeeRepository.existsById(employee.getId())) {
            return Optional.empty();
        }

        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public void delete(@PathVariable UUID id) {
        employeeRepository.deleteById(id);
    }

}
