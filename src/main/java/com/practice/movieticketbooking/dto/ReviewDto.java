package com.practice.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Builder
@AllArgsConstructor
public class ReviewDto {

    @NotEmpty(message = "Movie review  is Mandatory")
    @Size(min =3)
    private String movieReview;

    @NotEmpty(message = "Movie rating is Mandatory")
    private double rating;

    private Integer movieId;

}
