package com.example.jpa_practice.one_to_many.uni_many_to_one.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Getter @Setter @NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BLOG_ID")
    private int blogId;

    @Column(name ="BLOG_NAME")
    private String blogName;

    @Column(name ="READ_TIME")
    private int readTime;

    @Column(name="REVIEW")
    private int review;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name ="AUTHOR_ID")
    private Author author;

}
