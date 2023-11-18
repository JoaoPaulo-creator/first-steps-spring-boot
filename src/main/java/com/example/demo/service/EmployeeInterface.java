package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeInterface {

    List<Employee> show();

    Optional<Employee> index(UUID id);

    Optional<Employee> store(Employee employee);
}
