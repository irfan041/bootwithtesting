package com.example.bootwithtesting.repository;

import com.example.bootwithtesting.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviewRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByType(String type);
}
