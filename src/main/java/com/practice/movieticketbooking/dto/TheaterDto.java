package com.practice.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TheaterDto {
    private Integer id;

    @NotEmpty(message = "Theater name is Mandatory")
    private String name;

    @NotEmpty(message = "Theater city is mandatory")
    private String city;

    @NotEmpty(message = "Theater address is mandatory")
    private String address;

    private List<ShowDto> shows;


}
