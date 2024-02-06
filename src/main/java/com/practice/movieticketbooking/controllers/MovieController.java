package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.MovieDto;
import com.practice.movieticketbooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/title")
    public MovieDto findMovieByTitle(@RequestParam String title){
        return movieService.findMovieByTitle(title);
    }

    @GetMapping("/movieId")
    public MovieDto findMovieById(@RequestParam Integer movieId){
        return movieService.findMovieById(movieId);
    }

    @GetMapping("/genre")
    public List<MovieDto> findMovieByGenre(@RequestParam String genre){
        return movieService.findMoviesByGenre(genre);
    }

}