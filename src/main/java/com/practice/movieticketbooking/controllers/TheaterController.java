package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.TheaterDto;
import com.practice.movieticketbooking.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

   // @Min(value = 1, message = "Theater Id Cannot be -ve")
    @GetMapping("/{id}")
    public ResponseEntity<TheaterDto> getTheater(@PathVariable(name = "id") Integer id) {

        return ResponseEntity.ok(theaterService.getTheater(id));
    }
}
