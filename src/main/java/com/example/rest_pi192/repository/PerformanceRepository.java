package com.example.rest_pi192.repository;


import com.example.rest_pi192.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория представлений
 */
@Repository
public interface PerformanceRepository extends JpaRepository<Performance,Long > {

}
