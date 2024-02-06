package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.TheaterSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeats,Integer> {
}
