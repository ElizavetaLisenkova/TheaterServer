package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория залов
 */
@Repository
public interface HallRepository extends JpaRepository<Hall,Long > {

}
