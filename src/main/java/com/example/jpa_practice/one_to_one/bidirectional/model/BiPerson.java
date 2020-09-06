package com.example.jpa_practice.one_to_one.bidirectional.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "person")
@Getter @Setter @NoArgsConstructor
public class BiPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int personId;

    @Column(name = "PERSON_NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
    @JsonManagedReference
    private BiCar biCar;

    public void setBiCar(BiCar biCar) {
        this.biCar = biCar;
        biCar.setOwner(this);
    }

    public BiCar getBiCar() {
        return biCar;
    }
}
