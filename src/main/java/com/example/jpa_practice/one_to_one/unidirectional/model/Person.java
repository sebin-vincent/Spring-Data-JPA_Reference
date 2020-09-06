package com.example.jpa_practice.one_to_one.unidirectional.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "person")
@Getter @Setter @NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int personId;

    @Column(name = "PERSON_NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

}
