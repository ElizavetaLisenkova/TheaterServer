package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Sector;
import com.example.rest_pi192.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public void create(Sector sector){
        sectorRepository.save(sector);
    }

    public List<Sector> findAll (){
        return sectorRepository.findAll();
    }

    public Optional<Sector> findById(Long id){
        return sectorRepository.findById(id);
    }

    public void deleteById(Long id){
        sectorRepository.deleteById(id);
    }

}
