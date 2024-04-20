package com.nikolabojanic.airbnb.service;

import com.nikolabojanic.airbnb.converter.UserConverter;
import com.nikolabojanic.airbnb.domain.UserDomain;
import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.enumeration.UserRole;
import com.nikolabojanic.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    public UserDomain registerUser(UserEntity userEntity) {
        UserDomain userDomain = userConverter.convertEntityToDomain(userEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole(UserRole.GUEST);
        userRepository.save(userEntity);
        return userDomain;
    }
}
