package com.practice.movieticketbooking.services;

import com.practice.movieticketbooking.dto.UserDto;

public interface UserService {
     UserDto addUser(UserDto userDto);
     UserDto getUser(Integer id);
}
