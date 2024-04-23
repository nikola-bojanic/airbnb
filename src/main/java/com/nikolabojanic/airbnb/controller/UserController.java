package com.nikolabojanic.airbnb.controller;

import com.nikolabojanic.airbnb.converter.UserConverter;
import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.dto.UserDto;
import com.nikolabojanic.airbnb.dto.UserRegistrationRequestDto;
import com.nikolabojanic.airbnb.dto.UserRegistrationResponseDto;
import com.nikolabojanic.airbnb.dto.UserUpdateRequestDto;
import com.nikolabojanic.airbnb.dto.UserUpdateResponseDto;
import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.service.UserService;
import com.nikolabojanic.airbnb.validation.UserValidation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;
    private final UserValidation userValidation;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserRegistrationResponseDto> registerUser(
        @Validated @RequestBody UserRegistrationRequestDto requestDto) {
        UserEntity registrationEntity = userConverter.convertRegistrationRequestToEntity(requestDto);
        UserDomain registeredDomainObject = userService.createUser(registrationEntity);
        UserRegistrationResponseDto registrationResponseDto =
            userConverter.convertDomainToRegistrationResponse(registeredDomainObject);
        return new ResponseEntity<>(registrationResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{username}")
    public HttpStatus createHost(@PathVariable("username") String username) {
        userValidation.validateUsername(username);
        userService.createHost(username);
        return HttpStatus.OK;
    }

    @PutMapping(value = "/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserUpdateResponseDto> updateProfile(
        @PathVariable("username") String username,
        @Validated @RequestBody UserUpdateRequestDto requestDto) {
        userValidation.validateUsername(username);
        UserEntity existingUser = userService.findByUsername(username);
        UserEntity updateRequest = userConverter.convertUpdateRequestToEntity(requestDto, existingUser);
        UserEntity updatedUser = userService.updateUser(updateRequest);
        UserUpdateResponseDto responseDto = userConverter.convertEntityToUpdateResponse(updatedUser);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserEntity> users = userService.getAll();
        List<UserDto> response = users.stream()
            .map(userConverter::convertEntityToDto).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}