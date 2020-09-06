package com.example.jpa_practice.one_to_many.uni_one_to_many.model;


import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="author")
@Getter @Setter @NoArgsConstructor
public class ManyToAuthor {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private int authorId;

    @Column(name="AUTHOR_NAME")
    private String authorName;

    @Column(name="AGE")
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private Set<ManyToBlog> blogs=new HashSet<>();

}
