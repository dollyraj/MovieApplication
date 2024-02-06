package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
     void addReview(ReviewDto reviewDto,Integer movieId);

     List<ReviewDto> getReviewByMovieTitle(String title);
}
