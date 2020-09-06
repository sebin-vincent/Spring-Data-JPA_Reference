package com.example.jpa_practice.many_to_many.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter @Setter @NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "POST_NAME")
    private String postName;

    @Column(name = "RATING")
    private int rating;

    @OneToMany(mappedBy = "post",cascade = {CascadeType.ALL})
    private Set<PostTag> tags=new HashSet<>();


    public void addPostTag(PostTag postTag){
        tags.add(postTag);
    }

}
