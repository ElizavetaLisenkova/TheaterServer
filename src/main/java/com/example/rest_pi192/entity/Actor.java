package com.example.rest_pi192.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Класс-сущность актера
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "actor")
public class Actor {

    /**
     * Атрибут id, является первичным ключем
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Атрибут труппа, внешний ключ
     * Сюда записывается id труппы, к которой принадлежит актер
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "troup_id", referencedColumnName = "id")
    private Troup troup;

    /**
     * Атрибут ФИО актера
     */
    @Column(name = "full_name")
    private String fullName;

    public Troup getTroup() {
        return troup;
    }

    public void setTroup(Troup troup) {
        this.troup = troup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
