package com.practice.movieticketbooking.services.impl;

import com.practice.movieticketbooking.dto.ShowDto;
import com.practice.movieticketbooking.entities.*;
import com.practice.movieticketbooking.exceptions.ResourceNotFoundException;
import com.practice.movieticketbooking.repositories.MovieRepository;
import com.practice.movieticketbooking.repositories.ShowSeatsRepository;
import com.practice.movieticketbooking.repositories.ShowsRepository;
import com.practice.movieticketbooking.repositories.TheaterRepository;
import com.practice.movieticketbooking.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowsRepository showsRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {


        Optional<Movie> movie= movieRepository.findById(showDto.getMovieId());

        if (!movie.isPresent()) {
            throw new ResourceNotFoundException("Movie","Id" ,showDto.getMovieId());
        }

        Optional<Theater> theater= theaterRepository.findById(showDto.getTheaterId());

        if (!theater.isPresent()) {
            throw new ResourceNotFoundException("Theater","Id",showDto.getTheaterId());
        }

        //    log.info("Adding New Show: " + showResource);

        Show show = Show.DtoToShow(showDto);

        show.setMovie(movie.get());
        show.setTheater(theater.get());
        show.setSeats(generateShowSeats(show.getTheater().getSeats(), show));

        for (ShowSeat seatsEntity : show.getSeats()) {
            seatsEntity.setShow(show);
        }

        show = showsRepository.save(show);


        return Show.ShowToDto(show);
    }


    private List<ShowSeat> generateShowSeats(List<TheaterSeats> theaterSeatsEntities, Show show) {

        List<ShowSeat> showSeatsEntities = new ArrayList<>();

        for (TheaterSeats theaterSeats : theaterSeatsEntities) {

            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNumber(theaterSeats.getSeatNumber());
            showSeat.setSeatType(theaterSeats.getSeatType());
            showSeat.setRate(100);


            showSeatsEntities.add(showSeat);
        }

        return showSeatsRepository.saveAll(showSeatsEntities);
    }
    @Override
    public List<ShowDto> searchShows(String movieName, String cityName, String theaterName) {

        if(!StringUtils.hasText(cityName))
            new ArrayList<>();
        List<Show> shows;
        if(StringUtils.hasText(movieName))
            shows=showsRepository.findByMovieNameAndCity(movieName,cityName);
        else if(StringUtils.hasText(theaterName)){
            shows=showsRepository.findByTheaterAndCity(theaterName,cityName);
        }
        else{
            shows=showsRepository.findByCity(cityName);
        }
        if(CollectionUtils.isEmpty(shows))
            return new ArrayList<>();
        else
            return shows.stream().map(Show::ShowToDto).collect(Collectors.toList());
    }


}
