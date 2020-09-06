package com.example.jpa_practice.one_to_many.uni_many_to_one.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Author;
import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Blog;
import com.example.jpa_practice.one_to_many.uni_many_to_one.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("onetomany/endpoint")
    public ResponseDto getEndpoint(){

        ResponseDto responseDto=new ResponseDto();

        Blog blog=blogRepository.findById(1).get();

        responseDto.setPayload(blog);

        return responseDto;


    }

    @PostMapping("onetomany/endpoint/save")
    public ResponseDto saveEndpoint(){

        ResponseDto responseDto=new ResponseDto();



        Blog newBlog=new Blog();
        newBlog.setBlogName("blog4");
        newBlog.setReadTime(5);
        newBlog.setReview(4);

        Author newAuthor=new Author();
        newAuthor.setAuthorName("Abraham");
        newAuthor.setAge(24);

        newBlog.setAuthor(newAuthor);

        blogRepository.save(newBlog);

        responseDto.setPayload(newBlog);

        return responseDto;
    }


}
