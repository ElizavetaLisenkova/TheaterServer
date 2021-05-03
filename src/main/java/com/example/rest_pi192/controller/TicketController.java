package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Ticket;
import com.example.rest_pi192.exception.TicketNotFoundException;
import com.example.rest_pi192.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер, все методы аналогичны классу ActorController и в нем описаны
 */
@RestController
@RequestMapping(value = "ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    
//GET All
    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        final List<Ticket> ticketList = ticketService.findAll();

        return ticketList != null && !ticketList.isEmpty()
                ? new ResponseEntity<>(ticketList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
//GET BY ID
    @GetMapping(value = "/{id}")
    public Ticket findById(@PathVariable(name="id") Long id){
        return ticketService.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }
    
    
//POST 
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Ticket ticket){
        ticketService.create(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
//DELETE
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        ticketService.deleteById(id);
    }

        
//UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long id, @RequestBody Ticket newTicket) {
        Ticket ticket = ticketService.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        ticket.setPrice(newTicket.getPrice());
        ticket.setPerformance(newTicket.getPerformance());
        ticket.setPlace(newTicket.getPlace());
        ticket.setAvailability(newTicket.getAvailability());

      ticketService.create(ticket);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
