package com.example.bootwithtesting.repository;

import com.example.bootwithtesting.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByMovieId(int moviewId);
}
