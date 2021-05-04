package com.example.rest_pi192;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс, который запускает сервер (Точка входа в программу)
 */
@SpringBootApplication
public class RunServerApplication {

	/**
	 * Главный метод, который запускает сервер
	 */
	public static void main(String[] args) {
		SpringApplication.run(RunServerApplication.class, args);
	}

}
