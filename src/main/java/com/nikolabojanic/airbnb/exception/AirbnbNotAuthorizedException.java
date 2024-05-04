package com.nikolabojanic.airbnb.exception;

public class AirbnbNotAuthorizedException extends AirbnbRootException {
    public AirbnbNotAuthorizedException(String message) {
        super(message);
    }
}
