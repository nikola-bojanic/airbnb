package com.nikolabojanic.airbnb.service;

import com.nikolabojanic.airbnb.converter.UserConverter;
import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.enumeration.UserRole;
import com.nikolabojanic.airbnb.exception.AirbnbEntityNotFoundException;
import com.nikolabojanic.airbnb.repository.UserRepository;
import java.util.Optional;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    public UserService(
        UserRepository userRepository,
        @Lazy PasswordEncoder passwordEncoder,
        UserConverter userConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userConverter = userConverter;
    }

    public UserEntity findByUsername(String username) {
        Optional<UserEntity> exists = userRepository.findByUsername(username);
        return exists.orElseThrow(() ->
            new AirbnbEntityNotFoundException("User with username: " + username + " doesn't exist")
        );
    }

    public UserDomain createUser(UserEntity userEntity) {
        UserDomain userDomain = userConverter.convertEntityToDomain(userEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole(UserRole.GUEST);
        userRepository.save(userEntity);
        return userDomain;
    }

    public void createHost(String username) {
        UserEntity user = findByUsername(username);
        user.setRole(UserRole.HOST);
        userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity updateRequest) {
        return userRepository.save(updateRequest);
    }
}
