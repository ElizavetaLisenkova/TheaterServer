package com.example.rest_pi192.service;

import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Класс сервиса, содержит в себе бизнес-логику
 */
@Service
public class ActorService {

    /**
     * Поле репозиторий
     */
    private final ActorRepository actorRepository;

    /**
     * Конструктор - создаем объект сервиса с атрибутом репозитория
     * @param actorRepository
     */
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    /**
     * Метод, который создает новый объект
     * @param actor
     */
    public void create(Actor actor){
        actorRepository.save(actor);
    }

    /**
     * Метод поиска всех объектов
     * @return список всех найденных объектов
     */
    public List<Actor> findAll (){
        return actorRepository.findAll();
    }

    /**
     * Метод поиска конкретного объекта по его id
     * @param id
     * @return конкретный объект
     */
    public Optional<Actor> findById(Long id){
        return actorRepository.findById(id);
    }

    /**
     * Удаляет объект по его id
     * @param id
     */
    public void deleteById(Long id){
        actorRepository.deleteById(id);
    }

}
