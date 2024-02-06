package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.MovieDto;
import com.practice.movieticketbooking.dto.ShowDto;
import com.practice.movieticketbooking.dto.TheaterDto;
import com.practice.movieticketbooking.services.ShowService;
import com.practice.movieticketbooking.services.TheaterService;
import com.practice.movieticketbooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MovieService movieService;

    @Autowired
    private ShowService showService;

    @Autowired
    private TheaterService theaterService;


    @GetMapping("/greetings")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome to Shout Review!!", HttpStatus.CREATED);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Validated MovieDto movieDto){
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.CREATED);
    }

    @PostMapping("/addShow")
    public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDto) {
//        showService.addShow(showDto);
        return ResponseEntity.ok(showService.addShow(showDto));
    }


    @PostMapping("/addTheater")
    public ResponseEntity<TheaterDto> addTheater(@RequestBody @Validated TheaterDto theaterDto) {

        return ResponseEntity.ok(theaterService.addTheater(theaterDto));
    }


}
