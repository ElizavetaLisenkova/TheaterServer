package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void create(Actor actor){
        actorRepository.save(actor);
    }

    public List<Actor> findAll (){
        return actorRepository.findAll();
    }

    public Optional<Actor> findById(Long id){
        return actorRepository.findById(id);
    }

    public void deleteById(Long id){
        actorRepository.deleteById(id);
    }



}
