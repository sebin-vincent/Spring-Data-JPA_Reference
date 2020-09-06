package com.example.jpa_practice.one_to_many.uni_many_to_one.repository;

import com.example.jpa_practice.one_to_many.uni_many_to_one.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
