package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.ShowDto;

import java.util.List;

public interface ShowService {
    public ShowDto addShow(ShowDto showDto);
    public List<ShowDto> searchShows(String movieName, String cityName, String theaterName);
}
