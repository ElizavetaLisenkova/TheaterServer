package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.entity.Sector;
import com.example.rest_pi192.exception.SectorNotFoundException;
import com.example.rest_pi192.service.HallService;
import com.example.rest_pi192.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "sector")
public class SectorController {

    private final SectorService sectorService;
    private final HallService hallService;

    @Autowired
    public SectorController(SectorService sectorService, HallService hallService){
        this.sectorService = sectorService;
        this.hallService = hallService;
    }


    @GetMapping
    public ResponseEntity<List<Sector>> findAll() {
        final List<Sector> sectorList = sectorService.findAll();

        return sectorList != null && !sectorList.isEmpty()
                ? new ResponseEntity<>(sectorList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{id}")
    public Sector findById(@PathVariable(name="id") Long id){
        return sectorService.findById(id)
                .orElseThrow(() -> new SectorNotFoundException(id));
    }

    @GetMapping(value = "/{id}/hall")
    public Hall findHall(@PathVariable(name="id") Long id){
        Hall hall = sectorService.findById(id).get().getHall();
        return hall;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Sector sector){
        sectorService.create(sector);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        sectorService.deleteById(id);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable(value = "id") Long id, @RequestBody Sector newSector) {
        Sector sector = sectorService.findById(id)
                .orElseThrow(() -> new SectorNotFoundException(id));

        sector.setName(newSector.getName());
        sector.setHall(newSector.getHall());
        sector.setSeatsNumber(newSector.getSeatsNumber());

      sectorService.create(sector);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
