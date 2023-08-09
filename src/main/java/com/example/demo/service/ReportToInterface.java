package com.example.demo.service;

import com.example.demo.entity.Manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReportToInterface {

    List<Manager> show();

    Optional<Manager> index(UUID id);

    Manager store(Manager reportTo);

    Optional<Manager> update(UUID id, Manager reportTo);

    void delete(UUID id);


}
