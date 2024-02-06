package com.practice.movieticketbooking.dto;

import com.practice.movieticketbooking.enums.SeatType;

import java.util.Set;

public class BookingDto {

    //@NotEmpty(message = "SeatNumbers cannot be empty")
    private Set<String> seatsNumbers;

    //@Min(value = 1, message = "Invalid user ID")
    private Integer userId;

    //@Min(value = 1, message = "Invalid show ID")
    private Integer showId;

   // @NotNull(message = "seatType cannot be null")
    private SeatType seatType;

    public Set<String> getSeatsNumbers() {
        return seatsNumbers;
    }

    public void setSeatsNumbers(Set<String> seatsNumbers) {
        this.seatsNumbers = seatsNumbers;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
