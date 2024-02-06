package com.practice.movieticketbooking.dto;

import com.practice.movieticketbooking.enums.Genre;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MovieDto {
    private int id;
    @NotEmpty(message = "Movie name is Mandatory")
    @Size(min=2,message = "Movie name must be of minimum 2 characters")
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Double rating;// a single entity which is average rating of all reviews for a movie


}
