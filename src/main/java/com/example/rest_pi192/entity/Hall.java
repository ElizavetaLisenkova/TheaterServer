package com.example.rest_pi192.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(name = "hall")
public class Hall {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_places")
    private Integer totalPlaces;

    public String getName() {
        return name;
    }

    public Integer getTotalPlaces() {
        return totalPlaces;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalPlaces(Integer totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
