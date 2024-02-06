package com.practice.movieticketbooking.dto;

import com.practice.movieticketbooking.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    private long id;

    @NotEmpty(message = "User name is Mandatory")
    private String name;

    @NotEmpty(message = "password is Mandatory")
    private String password;



    private Role role;

    @NotEmpty(message = "Mobile is Mandatory")
    private String mobile;

   @NotEmpty(message = "Email is Mandatory")
   @Email(message = "Email address is not valid!")
    private String email;

    private List<TicketDto> tickets;


}
