package com.example.rest_pi192.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "performance_id")
    private String performanceId;

    @Column(name = "sector_id")
    private String sectorId;

    @Column(name = "place")
    private Integer place;

    @Column(name = "availability")
    private Boolean availability;


}
