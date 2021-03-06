package com.example.rest_pi192.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Класс-сущность театрального представления
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "performance")
public class Performance {
    /**
     * Атрибут id, является первичным ключем
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Атрибут название представления
     */
    @Column(name = "name")
    private String name;

    /**
     * Атрибут дата представления
     */
    @Column(name = "date")
    private String date;

    /**
     * Атрибут время представления
     */
    @Column(name = "time")
    private String time;

    /**
     * Атрибут труппа, внешний ключ
     * Сюда записывается id труппы, которая будет вытупать на представлении
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "troup_id", referencedColumnName = "id")
    private Troup troup;

    /**
     * Атрибут зала, внешний ключ
     * Сюда записывается id зала, где будет проходить представление
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall  hall;

    /**
     * Атрибут статус представления
     */
    @Column(name = "status")
    private String status;

    /**
     * Связь с билетами
     */
    @JsonIgnore
    @OneToMany(mappedBy = "performance", fetch = FetchType.LAZY)
    private Set<Ticket> tickets = new HashSet<Ticket>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Troup getTroup() {
        return troup;
    }

    public void setTroup(Troup troup) {
        this.troup = troup;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
