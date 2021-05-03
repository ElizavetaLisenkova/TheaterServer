package com.example.rest_pi192.service;

import com.example.rest_pi192.entity.Troup;
import com.example.rest_pi192.repository.TroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Класс сервиса, содержит в себе бизнес-логику
 */
@Service
public class TroupService {

    /**
     * Поле репозиторий
     */
    private final TroupRepository troupRepository;

    /**
     * Конструктор - создаем объект сервиса с атрибутом репозитория
     * @param troupRepository
     */
    @Autowired
    public TroupService(TroupRepository troupRepository) {
        this.troupRepository = troupRepository;
    }

    /**
     * Метод, который создает новый объект
     * @param troup
     */
    public void create(Troup troup){
        troupRepository.save(troup);
    }

    /**
     * Метод поиска всех объектов
     * @return список всех найденных объектов
     */
    public List<Troup> findAll (){
        return troupRepository.findAll();
    }

    /**
     * Метод поиска конкретного объекта по его id
     * @param id
     * @return конкретный объект
     */
    public Optional<Troup> findById(Long id){
        return troupRepository.findById(id);
    }

    /**
     * Удаляет объект по его id
     * @param id
     */
    public void deleteById(Long id){
        troupRepository.deleteById(id);
    }

}
