package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Performance;
import com.example.rest_pi192.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public void create(Performance performance){
        performanceRepository.save(performance);
    }

    public List<Performance> findAll (){
        return performanceRepository.findAll();
    }

    public Optional<Performance> findById(Long id){
        return performanceRepository.findById(id);
    }

    public void deleteById(Long id){
        performanceRepository.deleteById(id);
    }

}
