package com.nikolabojanic.airbnb.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
