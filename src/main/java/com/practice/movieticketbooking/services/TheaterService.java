package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.TheaterDto;

public interface TheaterService {
    public TheaterDto addTheater(TheaterDto theaterDto);
    public TheaterDto getTheater(Integer id);
}
