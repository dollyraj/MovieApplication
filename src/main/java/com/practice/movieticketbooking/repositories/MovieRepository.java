package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.Movie;
import com.practice.movieticketbooking.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    boolean existsByTitle(String title);
    public Movie findByTitle(String title);

    public List<Movie> findByGenre(Genre genre);
}
