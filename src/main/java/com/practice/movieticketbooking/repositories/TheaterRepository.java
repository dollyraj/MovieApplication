package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.Show;
import com.practice.movieticketbooking.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    @Query(value = "select * from theaters t where s.theater_id=t.id and m.title=?",nativeQuery = true)
    List<Show> findByTheaterName(String theaterName);
}
