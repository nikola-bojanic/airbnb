package com.nikolabojanic.airbnb.service.security;

import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AirbnbUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userService.findByUsername(username);
        String role = user.getRole().toString();
        return User.builder()
            .username(username)
            .password(user.getPassword())
            .authorities(role)
            .build();
    }
}