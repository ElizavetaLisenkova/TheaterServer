package com.example.rest_pi192.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Класс-сущность билета
 */
@Entity
@Data
@NoArgsConstructor
public class Ticket {
    /**
     * Атрибут id, является первичным ключем
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Атрибут цены билета
     */
    @Column(name = "price")
    private Double price;

    /**
     * Атрибут представления, внешний ключ
     * Сюда записывается id представления, для которого создан билет
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "performance_id", referencedColumnName = "id")
    private Performance performance;

    /**
     * Атрибут места (номер сиденья в зале) билета
     */
    @Column(name = "place")
    private Integer place;

    /**
     * Атрибут доступность, указывается свободно место или куплено
     */
    @Column(name = "availability")
    private Boolean availability;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

}
