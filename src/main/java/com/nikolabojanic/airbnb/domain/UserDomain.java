package com.nikolabojanic.airbnb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDomain {
    private String username;
    private String password;
}
