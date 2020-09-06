package com.example.jpa_practice.one_to_many.bi_one_to_many.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Getter @Setter @NoArgsConstructor
public class BiBlog {

    public BiBlog(String blogName, int readTime, int review) {
        this.blogName = blogName;
        this.readTime = readTime;
        this.review = review;
    }

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
    private BiAuthor biAuthor;




}
