package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.exception.ActorNotFoundException;
import com.example.rest_pi192.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Класс контроллера
 * Контроллеры делают такие вещи, как диспетчеризация, переадресация, вызов методов обслуживания и т. д.
 */
@RestController
@RequestMapping(value = "actor")
public class ActorController {

    /**
     * Переменная для обращения к сервису
     */
    private final ActorService actorService;

    /**
     * Конструктор класса с атрибутом сервиса
     * @param actorService
     */
    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    /**
     * GET-запрос - получает список всех актеров в Json-формате
     * @return список всех актеров в Json-формате
     */
    @GetMapping
    public ResponseEntity<List<Actor>> findAll() {
        final List<Actor> actorList = actorService.findAll();
        return actorList != null && !actorList.isEmpty()
                ? new ResponseEntity<>(actorList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * GET-запрос - производит поиск актера с конкретным id и возвращает его в Json-формате
     * @param id
     * @return конкретного актера в Json-формате
     */
    @GetMapping(value = "/{id}")
    public Actor findById(@PathVariable(name="id") Long id){
        return actorService.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    /**
     * POST-запрос - создает нового актера
     * @param actor
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Actor actor){
        actorService.create(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Удаляет актера по его id
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        actorService.deleteById(id);
    }

    /**
     * Обновляет информацию об актере по его id
     * @param id
     * @param newActor
     * @return
     */
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
