package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория актеров
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor,Long > {

}
