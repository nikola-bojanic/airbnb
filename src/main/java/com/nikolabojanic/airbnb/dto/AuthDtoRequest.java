package com.nikolabojanic.airbnb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDtoRequest {
    private String username;
    private String password;
}
