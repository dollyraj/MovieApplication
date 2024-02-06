package com.practice.movieticketbooking.entities;

import com.practice.movieticketbooking.dto.TheaterDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Show> shows = new ArrayList<>();

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @Builder.Default
    private List<TheaterSeats> seats = new ArrayList<>();


    public static Theater DtoToTheater(TheaterDto theaterDto){

        Theater theater=Theater.builder().name(theaterDto.getName())
                .city(theaterDto.getCity()).address(theaterDto.getAddress()).build();


        return theater;
    }


    public static TheaterDto TheaterToDto(Theater theater){

        TheaterDto theaterDto=TheaterDto.builder().id(theater.getId())
                .name(theater.getName()).city(theater.getCity()).address(theater.getAddress()).build();


        return  theaterDto;
    }


}
