package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.exception.ActorNotFoundException;
import com.example.rest_pi192.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }


    @GetMapping
    public ResponseEntity<List<Actor>> findAll() {
        final List<Actor> actorList = actorService.findAll();

        return actorList != null && !actorList.isEmpty()
                ? new ResponseEntity<>(actorList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{id}")
    public Actor findById(@PathVariable(name="id") Long id){
        return actorService.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

//    @GetMapping(value = "/{id}/troup")
//    public Optional<Troup> findTroup(@PathVariable(name="id") Long id){
//        Long troupId = actorService.findById(id).get().getTroupId();
//        return troupService.findById(troupId);
//    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Actor actor){
        actorService.create(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        actorService.deleteById(id);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Long id, @RequestBody Actor newActor) {
        Actor actor = actorService.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));

        actor.setTroup(newActor.getTroup());
        actor.setFullName(newActor.getFullName());

      actorService.create(actor);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
