package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.UserGender;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    @Size(min = 6, max = 16)
    private String username;
    @Size(min = 8, max = 60)
    private String password;
    @Size(min = 2, max = 50)
    private String firstName;
    @Size(min = 2, max = 50)
    private String lastName;
    private UserGender gender;
}
