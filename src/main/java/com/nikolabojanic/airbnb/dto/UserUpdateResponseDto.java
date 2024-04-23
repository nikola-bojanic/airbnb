package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.UserGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateResponseDto {
    private String username;
    private String firstName;
    private String lastName;
    private UserGender gender;
}