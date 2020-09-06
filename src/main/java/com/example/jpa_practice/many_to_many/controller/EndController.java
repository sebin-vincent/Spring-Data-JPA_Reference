package com.example.jpa_practice.many_to_many.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.many_to_many.model.Post;
import com.example.jpa_practice.many_to_many.model.PostTag;
import com.example.jpa_practice.many_to_many.model.Tag;
import com.example.jpa_practice.many_to_many.repository.PostRepository;
import com.example.jpa_practice.many_to_many.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/manytomany/endpoint")
    public ResponseDto getEndpoint(){
        ResponseDto responseDto=new ResponseDto();

        Post post=postRepository.findById(1).get();

        return responseDto;
    }

    @PostMapping("/manytomany/endpoint/save")
    public ResponseDto saveEndpoint(){
        ResponseDto responseDto=new ResponseDto();

        Post post=new Post();
        post.setPostName("Kafka");
        post.setRating(4);

        Tag tag1=new Tag();
        tag1.setTagName("Kafka Messaging");

        Tag tag2=new Tag();
        tag2.setTagName("Developer");

        PostTag postTag1=new PostTag(post,tag1);
        PostTag postTag2=new PostTag(post,tag2);

        post.addPostTag(postTag1);
        post.addPostTag(postTag2);

        postRepository.save(post);


        return responseDto;
    }

}
