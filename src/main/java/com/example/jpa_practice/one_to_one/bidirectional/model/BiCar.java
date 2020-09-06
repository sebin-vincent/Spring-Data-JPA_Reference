package com.example.jpa_practice.one_to_one.bidirectional.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="car")
@Setter @Getter @NoArgsConstructor
public class BiCar {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CAR_ID")
    private int carId;

    @Column(name="CAR_NAME")
    private String carName;

    @Column(name="MODEL")
    private int model;

    @Column(name="REGISTRATION_NUMBER ")
    private String regNumber;

    //If cascade option is not set we will get exception
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="OWNER_ID")
    @JsonBackReference
    private BiPerson owner;

}
