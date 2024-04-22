package com.nikolabojanic.airbnb.validation;

import com.nikolabojanic.airbnb.exception.AirbnbValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    public void validateUsername(String username) {
        if (username == null) {
            throw new AirbnbValidationException("Username must not be null");
        } else if (username.isBlank()) {
            throw new AirbnbValidationException("Username must not be blank");
        } else if (username.length() < 6 || username.length() > 16) {
            throw new AirbnbValidationException("Username must be between 6 and 16 characters");
        }
    }
}
