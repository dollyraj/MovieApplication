package com.practice.movieticketbooking.repositories;

import com.practice.movieticketbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByMobile(String mobile);

    User findByName(String name);
}
