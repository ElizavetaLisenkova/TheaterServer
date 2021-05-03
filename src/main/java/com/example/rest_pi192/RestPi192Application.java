package com.example.rest_pi192;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс, который запускает сервер
 */
@SpringBootApplication
public class RestPi192Application {

	/**
	 * Главный метод, который запускает сервер
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestPi192Application.class, args);
	}

}
