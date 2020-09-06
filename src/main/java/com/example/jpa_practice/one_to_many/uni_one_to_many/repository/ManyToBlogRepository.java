package com.example.jpa_practice.one_to_many.uni_one_to_many.repository;

import com.example.jpa_practice.one_to_many.uni_one_to_many.model.ManyToBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToBlogRepository extends JpaRepository<ManyToBlog,Integer> {
}
