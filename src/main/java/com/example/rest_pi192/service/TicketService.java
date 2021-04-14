package com.example.rest_pi192.service;


import com.example.rest_pi192.entity.Ticket;
import com.example.rest_pi192.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void create(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public List<Ticket> findAll (){
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Long id){
        return ticketRepository.findById(id);
    }

    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }

}
