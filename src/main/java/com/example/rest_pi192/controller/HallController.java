package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.exception.HallNotFoundException;
import com.example.rest_pi192.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "hall")
public class HallController {

    private final HallService hallService;


    public HallController(HallService hallService){
        this.hallService = hallService;
    }


    @GetMapping
    public ResponseEntity<List<Hall>> findAll() {
        final List<Hall> hallList = hallService.findAll();

        return hallList != null && !hallList.isEmpty()
                ? new ResponseEntity<>(hallList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{id}")
    public Hall findById(@PathVariable(name="id") Long id){
        return hallService.findById(id)
                .orElseThrow(() -> new HallNotFoundException(id));
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Hall hall){
        hallService.create(hall);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        hallService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Hall> updateHall(@PathVariable(value = "id") Long id, @RequestBody Hall newHall) {
        Hall hall = hallService.findById(id)
                .orElseThrow(() -> new HallNotFoundException(id));

        hall.setName(newHall.getName());
        hall.setTotalPlaces(newHall.getTotalPlaces());

      hallService.create(hall);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
