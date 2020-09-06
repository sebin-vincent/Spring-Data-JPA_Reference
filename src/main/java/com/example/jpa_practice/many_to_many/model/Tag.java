package com.example.jpa_practice.many_to_many.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Getter @Setter @NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private int tagId;

    @Column(name="TAG_NAME")
    private String tagName;
}
