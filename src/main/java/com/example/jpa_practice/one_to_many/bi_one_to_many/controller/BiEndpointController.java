package com.example.jpa_practice.one_to_many.bi_one_to_many.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.one_to_many.bi_one_to_many.model.BiAuthor;
import com.example.jpa_practice.one_to_many.bi_one_to_many.model.BiBlog;
import com.example.jpa_practice.one_to_many.bi_one_to_many.repository.BiAuthorRepository;
import com.example.jpa_practice.one_to_many.bi_one_to_many.repository.BiBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiEndpointController {

    @Autowired
    private BiAuthorRepository biAuthorRepository;

    @Autowired
    private BiBlogRepository biBlogRepository;

    @GetMapping("bi/endpoint")
    public ResponseDto getEndpoint(){

        ResponseDto responseDto=new ResponseDto();

        BiBlog biBlog = biBlogRepository.findById(1).get();

        responseDto.setPayload(biBlog);

        return responseDto;


    }

    @PostMapping("bi/endpoint/save")
    public ResponseDto saveEndpoint(){

        ResponseDto responseDto=new ResponseDto();

        BiAuthor biAuthor=new BiAuthor();
        biAuthor.setAuthorName("Abraham");
        biAuthor.setAge(25);
        biAuthor.addBlog(new BiBlog("Blog2",4,5));
        biAuthor.addBlog(new BiBlog("Blog3",3,4));
        biAuthor.addBlog(new BiBlog("Blog4",2,3));

        biAuthorRepository.save(biAuthor);




        return responseDto;
    }


}
