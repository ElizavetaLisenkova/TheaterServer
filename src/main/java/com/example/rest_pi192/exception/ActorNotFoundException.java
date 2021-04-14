package com.example.rest_pi192.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ActorNotFoundException extends RuntimeException{
    public ActorNotFoundException(Long id) {super("Актер с id "+ id + " не найден.");}
}
