package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long > {

}
