package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Troup;
import com.example.rest_pi192.repository.TroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TroupService {

    private final TroupRepository troupRepository;

    @Autowired
    public TroupService(TroupRepository troupRepository) {
        this.troupRepository = troupRepository;
    }

    public void create(Troup troup){
        troupRepository.save(troup);
    }

    public List<Troup> findAll (){
        return troupRepository.findAll();
    }

    public Optional<Troup> findById(Long id){
        return troupRepository.findById(id);
    }

    public void deleteById(Long id){
        troupRepository.deleteById(id);
    }

}
