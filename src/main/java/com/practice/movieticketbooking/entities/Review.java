package com.practice.movieticketbooking.entities;


import com.practice.movieticketbooking.dto.ReviewDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="review_table")
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String movieReview;

    private double rating;  // rating dedicated to each review.

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie; // it will add foreign key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;



    public static ReviewDto ReviewToDTO(Review review){


        ReviewDto reviewDto=ReviewDto.builder().movieReview(review.getMovieReview()).
                rating(review.getRating()).movieId(review.getMovie().getId()).build();

        return reviewDto;
    }

    public static Review DTOtoReview(ReviewDto reviewDto){

        Review review=Review.builder().movieReview(reviewDto.getMovieReview())
                .rating(reviewDto.getRating()).build();

        return review;


    }

}
