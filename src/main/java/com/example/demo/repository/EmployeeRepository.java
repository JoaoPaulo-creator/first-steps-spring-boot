package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.http.HttpHeaders;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
