package com.example.jpa_practice.one_to_one.unidirectional.controller;

import com.example.jpa_practice.dto.ResponseDto;
import com.example.jpa_practice.one_to_one.unidirectional.model.Car;
import com.example.jpa_practice.one_to_one.unidirectional.model.Person;
import com.example.jpa_practice.one_to_one.unidirectional.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniDirectionalController {

    @Autowired
    private CarRepository carRepository;


    @GetMapping("unidirectional/endpoint")
    public ResponseDto getOutput(){

        Car car = carRepository.findById(1).get();

        ResponseDto response=new ResponseDto();
        response.setPayload(car);

        return response;
    }

    @PostMapping("unidirectional/endpoint/save")
    public ResponseDto saveCar(){

        ResponseDto responseDto=new ResponseDto();

        Person person=new Person();
        person.setName("Abraham");
        person.setAge(22);

        Car car=new Car();
        car.setCarName("Crecta");
        car.setModel(2019);
        car.setRegNumber("KL09A2019");
        car.setOwner(person);
        carRepository.save(car);

        responseDto.setPayload(car);

        return responseDto;

    }

}
