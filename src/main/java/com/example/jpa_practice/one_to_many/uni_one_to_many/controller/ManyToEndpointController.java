package com.example.jpa_practice.one_to_many.uni_one_to_many.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Author;
import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Blog;
import com.example.jpa_practice.one_to_many.uni_one_to_many.model.ManyToAuthor;
import com.example.jpa_practice.one_to_many.uni_one_to_many.model.ManyToBlog;
import com.example.jpa_practice.one_to_many.uni_one_to_many.repository.ManyToAuthorRepository;
import com.example.jpa_practice.one_to_many.uni_one_to_many.repository.ManyToBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToEndpointController {

    @Autowired
    private ManyToBlogRepository manyToBlogRepository;

    @Autowired
    private ManyToAuthorRepository manyToAuthorRepository;

    @GetMapping("manyto/endpoint")
    public ResponseDto getEndpoint(){

        ResponseDto responseDto=new ResponseDto();

        ManyToAuthor manyToAuthor=manyToAuthorRepository.findById(1).get();

        responseDto.setPayload(manyToAuthor);

        return responseDto;


    }

    @PostMapping("manyto/endpoint/save")
    public ResponseDto saveEndpoint(){

        ResponseDto responseDto=new ResponseDto();

        ManyToAuthor newAuthor=new ManyToAuthor();
        newAuthor.setAuthorName("Abraham");
        newAuthor.setAge(23);

        newAuthor.getBlogs().add(new ManyToBlog("Blog5",4,5));
        newAuthor.getBlogs().add(new ManyToBlog("Blog6",3,4));
        newAuthor.getBlogs().add(new ManyToBlog("Blog7",2,3));

        manyToAuthorRepository.save(newAuthor);

        responseDto.setPayload(newAuthor);

        return responseDto;
    }


}
