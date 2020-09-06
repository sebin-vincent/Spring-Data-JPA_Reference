package com.example.jpa_practice.one_to_one.bidirectional.repository;

import com.example.jpa_practice.one_to_one.bidirectional.model.BiPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiPersonRepository extends JpaRepository<BiPerson,Integer> {
}
