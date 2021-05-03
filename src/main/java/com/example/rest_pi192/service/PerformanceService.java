package com.example.rest_pi192.service;

import com.example.rest_pi192.entity.Performance;
import com.example.rest_pi192.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Класс сервиса, содержит в себе бизнес-логику
 */
@Service
public class PerformanceService {

    /**
     * Поле репозиторий
     */
    private final PerformanceRepository performanceRepository;

    /**
     * Конструктор - создаем объект сервиса с атрибутом репозитория
     * @param performanceRepository
     */
    @Autowired
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    /**
     * Метод, который создает новый объект
     * @param performance
     */
    public void create(Performance performance){
        performanceRepository.save(performance);
    }

    /**
     * Метод поиска всех объектов
     * @return список всех найденных объектов
     */
    public List<Performance> findAll (){
        return performanceRepository.findAll();
    }

    /**
     * Метод поиска конкретного объекта по его id
     * @param id
     * @return конкретный объект
     */
    public Optional<Performance> findById(Long id){
        return performanceRepository.findById(id);
    }

    /**
     * Удаляет объект по его id
     * @param id
     */
    public void deleteById(Long id){
        performanceRepository.deleteById(id);
    }

}
