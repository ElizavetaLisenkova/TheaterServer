package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Troup;
import com.example.rest_pi192.exception.TroupNotFoundException;
import com.example.rest_pi192.service.TroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "troup")
public class TroupController {

    private final TroupService troupService;

    @Autowired
    public TroupController(TroupService troupService){
        this.troupService = troupService;
    }


    @GetMapping
    public ResponseEntity<List<Troup>> findAll() {
        final List<Troup> troupList = troupService.findAll();

        return troupList != null && !troupList.isEmpty()
                ? new ResponseEntity<>(troupList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{id}")
    public Troup findById(@PathVariable(name="id") Long id){
        return troupService.findById(id)
                .orElseThrow(() -> new TroupNotFoundException(id));
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Troup troup){
        troupService.create(troup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        troupService.deleteById(id);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Troup> updateTroup(@PathVariable(value = "id") Long id, @RequestBody Troup newTroup) {
        Troup troup = troupService.findById(id)
                .orElseThrow(() -> new TroupNotFoundException(id));

        troup.setName(newTroup.getName());

      troupService.create(troup);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
