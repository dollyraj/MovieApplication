package com.practice.movieticketbooking.entities;

import com.practice.movieticketbooking.dto.MovieDto;
import com.practice.movieticketbooking.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="Movies")
public class Movie {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    Genre genre;
    private Double rating;// a single entity which is average rating of all reviews for a movie
    @OneToMany(mappedBy="movie")
    private List<Review> reviews;



    public static MovieDto movieToDTO(Movie movie){

        MovieDto movieDto=MovieDto.builder().id(movie.getId()).title(movie.getTitle())
                .genre(movie.getGenre()).rating(movie.getRating()).build();


        return movieDto;
    }

    public static Movie DTOtoMovie(MovieDto movieDto){

        Movie movie =Movie.builder().title(movieDto.getTitle()).genre(movieDto.getGenre()).rating(0.0).build();


        return movie;
    }


}
