package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeat,Integer> {
}
