package com.example.demo.controller;


import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @GetMapping("/manager")
    public ResponseEntity<List<Manager>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.show());
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<Object> findOne(@PathVariable UUID id) {
        Optional<Manager> manager = service.index(id);
        if (manager.isEmpty()) {
            var apiResponse = new ApiResponse("manager not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(manager);
    }

    @PostMapping("/manager")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.store(manager));
    }


}
