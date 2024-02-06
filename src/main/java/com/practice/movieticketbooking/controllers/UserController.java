package com.practice.movieticketbooking.controllers;

import com.practice.movieticketbooking.dto.UserDto;
import com.practice.movieticketbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserDto> addUser(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    //@Min(value = 1, message = "User Id Cannot be -ve")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
