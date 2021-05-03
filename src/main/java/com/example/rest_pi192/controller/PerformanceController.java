package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Performance;
import com.example.rest_pi192.exception.PerformanceNotFoundException;
import com.example.rest_pi192.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер, все методы аналогичны классу ActorController и в нем описаны
 */
@RestController
@RequestMapping(value = "performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    @Autowired
    public PerformanceController(PerformanceService performanceService){
        this.performanceService = performanceService;
    }

//GET All
    @GetMapping
    public ResponseEntity<List<Performance>> findAll() {
        final List<Performance> performanceList = performanceService.findAll();

        return performanceList != null && !performanceList.isEmpty()
                ? new ResponseEntity<>(performanceList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//GET BY ID
    @GetMapping(value = "/{id}")
    public Performance findById(@PathVariable(name="id") Long id){
        return performanceService.findById(id)
                .orElseThrow(() -> new PerformanceNotFoundException(id));
    }


//POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Performance performance){
        performanceService.create(performance);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//DELETE
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        performanceService.deleteById(id);
    }


//UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Performance> updatePerformance(@PathVariable(value = "id") Long id, @RequestBody Performance newPerformance) {
        Performance performance = performanceService.findById(id)
                .orElseThrow(() -> new PerformanceNotFoundException(id));

        performance.setName(newPerformance.getName());
        performance.setDate(newPerformance.getDate());
        performance.setTime(newPerformance.getTime());
        performance.setHall(newPerformance.getHall());
        performance.setTroup(newPerformance.getTroup());
        performance.setStatus(newPerformance.getStatus());

      performanceService.create(performance);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
