package com.practice.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TicketDto {
    private long id;

    private String allottedSeats;

    private double amount;

    private Date bookedAt;

    private ShowDto showDto;

}
