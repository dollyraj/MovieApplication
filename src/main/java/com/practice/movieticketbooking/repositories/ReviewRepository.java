package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
    @Query(value = "select avg(rating) from review_table where movie_id=?",nativeQuery = true)
    Double getRatingAverage(Integer id);

}
