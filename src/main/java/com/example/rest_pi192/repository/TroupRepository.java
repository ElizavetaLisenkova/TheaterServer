package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Troup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория трупп
 */
@Repository
public interface TroupRepository extends JpaRepository<Troup,Long > {

}
