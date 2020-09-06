package com.example.jpa_practice.many_to_many.model.embedabble;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@Getter @Setter @NoArgsConstructor
public class PostTagId implements Serializable{

    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "TAG_ID")
    private int tagId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostTagId)) return false;
        PostTagId postTagId = (PostTagId) o;
        return getPostId() == postTagId.getPostId() &&
                getTagId() == postTagId.getTagId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getTagId());
    }
}
