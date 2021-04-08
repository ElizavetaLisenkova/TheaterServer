package com.example.rest_pi192.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
public class Troup {
    @Id
    private long id;

    private String actorFullName;


}

