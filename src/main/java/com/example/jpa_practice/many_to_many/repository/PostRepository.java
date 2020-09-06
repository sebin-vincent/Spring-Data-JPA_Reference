package com.example.jpa_practice.many_to_many.repository;

import com.example.jpa_practice.many_to_many.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
