package com.example.jpa_practice.one_to_many.uni_many_to_one.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="author")
@Getter @Setter @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private int authorId;

    @Column(name="AUTHOR_NAME")
    private String authorName;

    @Column(name="AGE")
    private int age;

}
