package com.example.rest_pi192.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "troup_id", referencedColumnName = "id")
    private Troup troup;

    @Column(name = "full_name")
    private String fullName;

    public Troup getTroup() {
        return troup;
    }

    public void setTroup(Troup troup) {
        this.troup = troup;
    }

//    public long getTroupId() {
//        return troupId;
//    }
//
//    public void setTroupId(long troupId) {
//        this.troupId = troupId;
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
