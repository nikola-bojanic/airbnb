package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.dto.UserRegistrationRequestDto;
import com.nikolabojanic.airbnb.dto.UserRegistrationResponseDto;
import com.nikolabojanic.airbnb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertRegistrationRequestToEntity(UserRegistrationRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(requestDto.getUsername());
        userEntity.setPassword(requestDto.getPassword());
        userEntity.setFirstName(requestDto.getFirstName());
        userEntity.setLastName(requestDto.getLastName());
        userEntity.setGender(requestDto.getGender());
        return userEntity;
    }

    public UserDomain convertEntityToDomain(UserEntity userEntity) {
        return new UserDomain(userEntity.getUsername(), userEntity.getPassword());
    }

    public UserRegistrationResponseDto convertDomainToRegistrationResponse(UserDomain userDomain) {
        return new UserRegistrationResponseDto(userDomain.getUsername(), userDomain.getPassword());
    }

}
