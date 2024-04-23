package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.dto.UserRegistrationRequestDto;
import com.nikolabojanic.airbnb.dto.UserRegistrationResponseDto;
import com.nikolabojanic.airbnb.dto.UserUpdateRequestDto;
import com.nikolabojanic.airbnb.dto.UserUpdateResponseDto;
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

    public UserEntity convertUpdateRequestToEntity(UserUpdateRequestDto requestDto, UserEntity user) {
        if (requestDto.getUsername() != null) {
            user.setUsername(requestDto.getUsername());
        }
        if (requestDto.getPassword() != null) {
            user.setPassword(requestDto.getPassword());
        }
        if (requestDto.getFirstName() != null) {
            user.setFirstName(requestDto.getFirstName());
        }
        if (requestDto.getLastName() != null) {
            user.setLastName(requestDto.getLastName());
        }
        if (requestDto.getGender() != null) {
            user.setGender(requestDto.getGender());
        }
        return user;
    }

    public UserUpdateResponseDto convertEntityToUpdateResponse(UserEntity userEntity) {
        return new UserUpdateResponseDto(
            userEntity.getUsername(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getGender());
    }

}
