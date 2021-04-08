package com.example.rest_pi192.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String date;
    private String time;
    private long troupeId;
    private String  hallName;
    private String status;


}
