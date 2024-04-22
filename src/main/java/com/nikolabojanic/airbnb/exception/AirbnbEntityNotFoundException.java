package com.nikolabojanic.airbnb.exception;

public class AirbnbEntityNotFoundException extends AirbnbRootException {
    public AirbnbEntityNotFoundException(String message) {
        super(message);
    }
}
