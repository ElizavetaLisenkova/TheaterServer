package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RequestMapping(value = "hall")
@RestController
public class HallController {

    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService){
        this.hallService = hallService;
    }


    @GetMapping(value = "hall")
    public ResponseEntity<List<Hall>> findAll() {
        final List<Hall> hallList = hallService.findAll();

        return hallList != null && !hallList.isEmpty()
                ? new ResponseEntity<>(hallList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "hall/{id}")
    public Optional<Hall> findById(@PathVariable(name="id") Long id){
        return hallService.findById(id);

//        return hall != null
//                ? new ResponseEntity<>(hall, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "hall")
    public ResponseEntity<?> create(@RequestBody Hall hall){
        hallService.create(hall);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @DeleteMapping(value = "{id")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        hallService.deleteById(id);
//    }
}
