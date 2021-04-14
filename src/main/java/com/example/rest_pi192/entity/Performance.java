package com.example.rest_pi192.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "performance")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "troup_id")
    private long troupeId;

    @Column(name = "hall_id")
    private String  hallId;

    @Column(name = "status")
    private String status;


}
