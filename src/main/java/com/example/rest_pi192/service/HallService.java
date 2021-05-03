package com.example.rest_pi192.service;

import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Класс сервиса, содержит в себе бизнес-логику
 */
@Service
public class HallService {

    /**
     * Поле репозиторий
     */
    private final HallRepository hallRepository;

    /**
     * Конструктор - создаем объект сервиса с атрибутом репозитория
     * @param hallRepository
     */
    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    /**
     * Метод, который создает новый объект
     * @param hall
     */
    public void create(Hall hall){
        hallRepository.save(hall);
    }

    /**
     * Метод поиска всех объектов
     * @return список всех найденных объектов
     */
    public List<Hall> findAll (){
        return hallRepository.findAll();
    }

    /**
     * Метод поиска конкретного объекта по его id
     * @param id
     * @return конкретный объект
     */
    public Optional<Hall> findById(Long id){
        return hallRepository.findById(id);
    }

    /**
     * Удаляет объект по его id
     * @param id
     */
    public void deleteById(Long id){
        hallRepository.deleteById(id);
    }

}
