package com.example.jpa_practice.one_to_many.bi_one_to_many.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="author")
@Getter @Setter @NoArgsConstructor
public class BiAuthor {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private int authorId;

    @Column(name="AUTHOR_NAME")
    private String authorName;

    @Column(name="AGE")
    private int age;

    @OneToMany(mappedBy = "biAuthor",cascade = CascadeType.ALL)
    private Set<BiBlog> blogs=new HashSet<>();


    public void addBlog(BiBlog blog){
        blogs.add(blog);
        blog.setBiAuthor(this);
    }

}
