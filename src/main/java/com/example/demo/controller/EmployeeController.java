package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import static com.example.demo.utils.ResponseMessageSerializer.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /*
     * O ResponseEntity<T> serve para retornar e ter controle do status http por
     * completo, headers, content type, etc.
     *
     */

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.show());
    }

    @PostMapping("/employees")
    public Optional<Object> newEmployee(@RequestBody Employee employee) throws IllegalArgumentException {
        // TODO: retornar um json com o erro
        return service.store(employee)
                .map(savedEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee).getBody());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> findOne(@PathVariable UUID id) {
        Optional<Employee> e = service.index(id);
        if (e.isEmpty()) {
            var apiResponse = new ApiResponse("Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(e);
    }
}
