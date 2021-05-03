package com.example.rest_pi192.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс ошибки при ненахождении объекта
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PerformanceNotFoundException extends RuntimeException{
    public PerformanceNotFoundException(Long id) {super("Представление с id "+ id + " не найден.");}
}
