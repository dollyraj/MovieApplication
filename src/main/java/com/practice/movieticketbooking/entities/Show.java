package com.practice.movieticketbooking.entities;

import com.practice.movieticketbooking.dto.ShowDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "shows")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Show {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalDateTime showTime;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;


    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> seats;



    public static ShowDto ShowToDto(Show show) {
        ShowDto showDto=ShowDto.builder().id(show.getId())
                .showTime(show.getShowTime())
                .movieId(show.getMovie().getId())
                .theaterId(show.getTheater().getId())
                .seats(ShowSeat.ShowSeatsDto(show.getSeats()))
                .createdAt(show.getCreatedAt())
                .updatedAt(show.getUpdatedAt())
                .build();


        //showDto.setMovieDto(Movie.movieToDTO(show.getMovie()));
       // showDto.setTheaterDto(Theater.TheaterToDto(show.getTheater()));

       return showDto;

    }

    public static Show DtoToShow(ShowDto showDto) {

        Show show=Show.builder().showTime(showDto.getShowTime())
                .createdAt(showDto.getCreatedAt())
                .updatedAt(showDto.getUpdatedAt()).build();


        return show;
    }


}
