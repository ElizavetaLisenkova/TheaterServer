package com.example.rest_pi192.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


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

    @JsonIgnore
    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY)
    private Set<Sector> sectors = new HashSet<Sector>();

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

}
