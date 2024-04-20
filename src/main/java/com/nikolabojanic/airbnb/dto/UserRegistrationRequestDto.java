package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.UserGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRegistrationRequestDto {
    @NotBlank
    @Size(min = 6, max = 16, message = "Size of the username must be between 6 and 16 characters")
    private String username;
    @NotBlank
    @Size(min = 8, max = 60)
    private String password;
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;
    @NotNull
    private UserGender gender;
}