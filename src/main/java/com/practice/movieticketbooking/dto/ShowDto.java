package com.practice.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShowDto {

    private Integer id;


    private LocalDateTime showTime;

    private Integer movieId;


    private Integer theaterId;

    private Date createdAt;

    private Date updatedAt;

    private MovieDto movieDto;

    private TheaterDto theaterDto;



    private List<ShowSeatsDto> seats;


}
