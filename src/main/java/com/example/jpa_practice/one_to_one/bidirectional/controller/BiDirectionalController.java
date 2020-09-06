package com.example.jpa_practice.one_to_one.bidirectional.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.one_to_one.bidirectional.model.BiCar;
import com.example.jpa_practice.one_to_one.bidirectional.model.BiPerson;
import com.example.jpa_practice.one_to_one.bidirectional.repository.BiCarRepository;
import com.example.jpa_practice.one_to_one.bidirectional.repository.BiPersonRepository;
import com.example.jpa_practice.one_to_one.unidirectional.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiDirectionalController {

    @Autowired
    private BiCarRepository biCarRepository;

    @Autowired
    private BiPersonRepository biPersonRepository;


    @GetMapping("bidirectional/endpoint")
    public ResponseDto getOutput(){

        BiCar biCar=biCarRepository.findById(1).get();

        BiPerson biPerson=biPersonRepository.findById(1).get();

        ResponseDto response=new ResponseDto();
        response.setPayload(biPerson);

        return response;
    }

    @PostMapping("bidirectional/endpoint/save")
    public ResponseDto saveCar(){

        ResponseDto responseDto=new ResponseDto();

        BiPerson biPerson =new BiPerson();
        biPerson.setName("Abraham");
        biPerson.setAge(22);

        BiCar biCar =new BiCar();
        biCar.setCarName("Crecta");
        biCar.setModel(2019);
        biCar.setRegNumber("KL09A2019");

        biPerson.setBiCar(biCar);

        biPersonRepository.save(biPerson);

        responseDto.setPayload(biPerson);

        return responseDto;

    }

}
