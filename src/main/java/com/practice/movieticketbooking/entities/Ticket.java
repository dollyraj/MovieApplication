package com.practice.movieticketbooking.entities;


import com.practice.movieticketbooking.dto.TicketDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tickets")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "alloted_seats", nullable = false)
    private String allottedSeats;

    @Column(name = "amount", nullable = false)
    private double amount;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> seats;


    public static List<TicketDto> TicketToDtoList(List<Ticket> tickets){
        if(CollectionUtils.isEmpty(tickets))
            return new ArrayList<>();
        return tickets.stream().map(Ticket::TicketToDto).collect(Collectors.toList());
    }

    public static Ticket DtoToTicket(TicketDto ticketDto) {

        Ticket ticket=Ticket.builder().allottedSeats(ticketDto.getAllottedSeats())
                .amount(ticketDto.getAmount()).build();

       return ticket;
    }

    public static TicketDto TicketToDto(Ticket ticket) {

      TicketDto ticketDto=TicketDto.builder()
              .id(ticket.getId())
              .allottedSeats(ticket.getAllottedSeats())
              .amount(ticket.getAmount())
              .bookedAt(ticket.getBookedAt())
              .build();

        return ticketDto;
    }

}
