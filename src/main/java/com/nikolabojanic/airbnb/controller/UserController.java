package com.nikolabojanic.airbnb.controller;

import com.nikolabojanic.airbnb.converter.UserConverter;
import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.dto.UserRegistrationRequestDto;
import com.nikolabojanic.airbnb.dto.UserRegistrationResponseDto;
import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserRegistrationResponseDto> registerUser(
        @Validated @RequestBody UserRegistrationRequestDto requestDto) {
        UserEntity registrationEntity = userConverter.convertRegistrationRequestToEntity(requestDto);
        UserDomain registeredDomainObject = userService.registerUser(registrationEntity);
        UserRegistrationResponseDto registrationResponseDto =
            userConverter.convertDomainToRegistrationResponse(registeredDomainObject);
        return new ResponseEntity<>(registrationResponseDto, HttpStatus.CREATED);
    }

}