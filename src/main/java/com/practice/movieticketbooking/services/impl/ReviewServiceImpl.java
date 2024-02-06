package com.practice.movieticketbooking.services.impl;

import com.practice.movieticketbooking.dto.ReviewDto;
import com.practice.movieticketbooking.entities.Movie;
import com.practice.movieticketbooking.entities.Review;
import com.practice.movieticketbooking.exceptions.ResourceNotFoundException;
import com.practice.movieticketbooking.repositories.MovieRepository;
import com.practice.movieticketbooking.repositories.ReviewRepository;
import com.practice.movieticketbooking.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public void addReview(ReviewDto reviewDto, Integer movieId) {
        Optional<Movie> OptionalMovie=movieRepository.findById(movieId);
        if(OptionalMovie.isEmpty()){
            throw new ResourceNotFoundException("Movie","Id",movieId);
        }


        Movie movie=OptionalMovie.get();
        Review review=Review.DTOtoReview(reviewDto);
        review.setMovie(movie);
        reviewRepository.save(review);
        //need to optimized
        //exception handling.
        if(movie!=null) {

            Double average = reviewRepository.getRatingAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }



    @Override
    public List<ReviewDto> getReviewByMovieTitle(String title) {
        Movie movie=movieRepository.findByTitle(title);
        //System.out.println(movie.getReviews().size());
        //System.out.println(movie.getId());
        if(Objects.isNull(movie)){
            throw new ResourceNotFoundException("Movie","Title",title);
        }

        List<Review> review=new ArrayList<>();
        for(Review r: movie.getReviews()){
            review.add(r);
        }

        if(review.isEmpty()){
            throw new ResourceNotFoundException("No reviews till now","Title",title);
        }

        List<ReviewDto> reviewList=new ArrayList<>();
        for(Review r:review){
            reviewList.add(Review.ReviewToDTO(r));
        }
        return reviewList;
    }


}
