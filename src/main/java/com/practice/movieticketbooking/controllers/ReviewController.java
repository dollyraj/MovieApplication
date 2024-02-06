package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.ReviewDto;
import com.practice.movieticketbooking.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/add/{movieId}")
    public void addReview(@RequestBody ReviewDto reviewDto,@PathVariable("movieId") Integer movieId){
        reviewService.addReview(reviewDto,movieId);
    }


    @GetMapping("/find/{movie_title}")
    public List<ReviewDto> getReview(@PathVariable String movie_title){
        return reviewService.getReviewByMovieTitle(movie_title);
    }

}
