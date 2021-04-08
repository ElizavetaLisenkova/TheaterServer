package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public void create(Hall hall){
        hallRepository.save(hall);
    }

    public List<Hall> findAll (){
        return hallRepository.findAll();
    }

    public Optional<Hall> findById(Long id){
        return hallRepository.findById(id);
    }

    public void deleteById(Long id){
        hallRepository.deleteById(id);
    }

}
