package com.practice.movieticketbooking.entities;

import com.practice.movieticketbooking.dto.UserDto;
import com.practice.movieticketbooking.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> ticketEntities;

    @Enumerated(EnumType.STRING)
    @Column(name = "role" ,columnDefinition = "varchar(30) default 'USER'")
    private Role role;




    public static User DtoToUser(UserDto userDto) {
      User user=User.builder()
              .name(userDto.getName())
              .password(userDto.getPassword())
              .role(userDto.getRole())
              .mobile(userDto.getMobile())
              .email(userDto.getEmail())
              .build();


        return user;

    }

    public static UserDto UserToDto(User user) {

        UserDto userDto=UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .mobile(user.getMobile())
                .email(user.getEmail())
                .tickets(Ticket.TicketToDtoList(user.getTicketEntities()))
                .build();

        return userDto;
    }


}
