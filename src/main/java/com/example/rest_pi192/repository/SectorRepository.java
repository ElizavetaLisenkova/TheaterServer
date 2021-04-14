package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long > {

}
