package com.example.jpa_practice.one_to_one.bidirectional.repository;

import com.example.jpa_practice.one_to_one.bidirectional.model.BiCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiCarRepository extends JpaRepository<BiCar,Integer> {
}
