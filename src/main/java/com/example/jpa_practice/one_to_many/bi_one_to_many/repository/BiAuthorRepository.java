package com.example.jpa_practice.one_to_many.bi_one_to_many.repository;


import com.example.jpa_practice.one_to_many.bi_one_to_many.model.BiAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiAuthorRepository extends JpaRepository<BiAuthor,Integer> {
}
