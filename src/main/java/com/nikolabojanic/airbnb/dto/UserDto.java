package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.UserGender;
import com.nikolabojanic.airbnb.enumeration.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private UserGender gender;
    private UserRole role;
}
