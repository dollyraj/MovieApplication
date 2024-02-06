package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.ShowDto;
import com.practice.movieticketbooking.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/search")
    public ResponseEntity<List<ShowDto>> search(
            @RequestParam(name="city",required = true) String cityName,
            @RequestParam(name = "movieName", required = false) String movieName,
            @RequestParam(name =  "theaterName",required = false) String theaterName) {
        return ResponseEntity.ok(showService.searchShows(movieName,cityName,theaterName));
    }


}
