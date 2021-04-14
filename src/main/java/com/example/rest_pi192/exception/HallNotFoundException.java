package com.example.rest_pi192.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HallNotFoundException extends RuntimeException{
    public HallNotFoundException(Long id) {super("Зал с id "+ id + " не найден.");}
}
