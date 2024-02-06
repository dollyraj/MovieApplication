package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.BookingDto;
import com.practice.movieticketbooking.dto.TicketDto;

public interface TicketService {
     TicketDto bookTicket(BookingDto bookingDto);
     TicketDto getTicket(Integer id);
}
