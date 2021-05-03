package com.example.rest_pi192.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс-сущность труппы
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "troup")
public class Troup {
    /**
     * Атрибут id, является первичным ключем
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Атрибут название труппы
     */
    @Column(name = "name")
    private String name;

    /**
     * Связь с актерами
     */
    @JsonIgnore
    @OneToMany(mappedBy = "troup", fetch = FetchType.LAZY)
    private Set<Actor> actors = new HashSet<Actor>();

    /**
     * Связь с представлениями
     */
    @JsonIgnore
    @OneToMany(mappedBy = "troup", fetch = FetchType.LAZY)
    private Set<Performance> performances = new HashSet<Performance>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

