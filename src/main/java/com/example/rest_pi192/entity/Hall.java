package com.example.rest_pi192.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс-сущность зала
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "hall")
public class Hall {
    /**
     * Атрибут id, является первичным ключем
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Атрибут название зала
     */
    @Column(name = "name")
    private String name;

    /**
     * Атрибут количество мест в зале
     */
    @Column(name = "total_places")
    private Integer totalPlaces;

    /**
     * Связь один ко многим с представлениями
     */
    @JsonIgnore
    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY)
    private Set<Performance> performances = new HashSet<Performance>();

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
