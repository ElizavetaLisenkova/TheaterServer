package com.example.rest_pi192.service;

import com.example.rest_pi192.entity.Ticket;
import com.example.rest_pi192.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Класс сервиса, содержит в себе бизнес-логику
 */
@Service
public class TicketService {

    /**
     * Поле репозиторий
     */
    private final TicketRepository ticketRepository;

    /**
     * Конструктор - создаем объект сервиса с атрибутом репозитория
     * @param ticketRepository
     */
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Метод, который создает новый объект
     * @param ticket
     */
    public void create(Ticket ticket){
        ticketRepository.save(ticket);
    }

    /**
     * Метод поиска всех объектов
     * @return список всех найденных объектов
     */
    public List<Ticket> findAll (){
        return ticketRepository.findAll();
    }

    /**
     * Метод поиска конкретного объекта по его id
     * @param id
     * @return конкретный объект
     */
    public Optional<Ticket> findById(Long id){
        return ticketRepository.findById(id);
    }

    /**
     * Удаляет объект по его id
     * @param id
     */
    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }

}
