package com.example.jpa_practice.many_to_many.model;

import com.example.jpa_practice.many_to_many.model.embedabble.PostTagId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "post_tags")
@Getter @Setter @NoArgsConstructor
public class PostTag {

    @EmbeddedId
    private PostTagId postTagId;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("postId") //Name of the variable in Embeddable
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.PERSIST})
    @MapsId("tagId")
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    public PostTag(Post post,Tag tag){
        this.post=post;
        this.tag=tag;
        this.postTagId=new PostTagId(post.getPostId(), tag.getTagId());
    }

}
