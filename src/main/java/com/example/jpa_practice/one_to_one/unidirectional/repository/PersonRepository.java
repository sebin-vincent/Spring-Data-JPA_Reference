package com.example.jpa_practice.one_to_one.unidirectional.repository;

import com.example.jpa_practice.one_to_one.unidirectional.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
