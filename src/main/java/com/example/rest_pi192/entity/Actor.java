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

    @Column(name = "troup_id")
    private long troupId;

    @Column(name = "full_name")
    private String fullName;
}
