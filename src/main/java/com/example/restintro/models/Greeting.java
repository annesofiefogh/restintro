package com.example.restintro.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter //Lombok autogenerates getters for attributes
@Setter //Lombok autogenerates setters for attributes
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Besked", unique = true) //can't have another column with the name "besked"
    private String message = "1. Hello from REST service";

    @Column
    private String message2 = "2. Hello again";

    @Column
    private String message3 = "3. Hello again, again";
}
