package com.practice.movieticketbooking.entities;

import com.practice.movieticketbooking.dto.ShowSeatsDto;
import com.practice.movieticketbooking.enums.SeatType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "show_seats")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "is_booked", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Ticket ticket;



    public static List<ShowSeatsDto> ShowSeatsDto(List<ShowSeat> seats) {

        if (!CollectionUtils.isEmpty(seats)) {
            return seats.stream().map(ShowSeat::ShowSeatToDto).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public static ShowSeatsDto ShowSeatToDto(ShowSeat showSeat) {


        ShowSeatsDto showSeatsDto=ShowSeatsDto.builder()
                .id(showSeat.getId())
                .seatNumber(showSeat.getSeatNumber())
                .rate(showSeat.getRate())
                .seatType(showSeat.getSeatType())
                .booked(showSeat.isBooked())
                .bookedAt(showSeat.getBookedAt())
                .build();


        return showSeatsDto;

    }

}
