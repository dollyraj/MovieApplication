package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.MovieDto;

import java.util.List;


public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);
    MovieDto findMovieByTitle(String title);
    MovieDto findMovieById(Integer movieId);

    List<MovieDto> findMoviesByGenre(String genre);
}
