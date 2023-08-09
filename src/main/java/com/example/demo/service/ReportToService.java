package com.example.demo.service;


import com.example.demo.entity.Manager;
import com.example.demo.repository.ReportToRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReportToService implements ReportToInterface {

    private final ReportToRepository reportToRepository;


    public ReportToService(ReportToRepository reportToRepository) {
        this.reportToRepository = reportToRepository;
    }


    @Override
    public List<Manager> show() {
        return reportToRepository.findAll();
    }

    @Override
    public Optional<Manager> index(UUID id) {
        return reportToRepository.findById(id);
    }

    @Override
    public Manager store(Manager reportTo) {
        return reportToRepository.save(reportTo);
    }

    @Override
    public Optional<Manager> update(UUID id, Manager reportTo) {
        if(reportTo.getId() == null) {
            return Optional.empty();
        }

        return Optional.of(reportToRepository.save(reportTo));
    }

    @Override
    public void delete(UUID id) {
        reportToRepository.deleteById(id);
    }
}
