package com.nikolabojanic.airbnb.service.security;

import com.nikolabojanic.airbnb.entity.UserEntity;
import com.nikolabojanic.airbnb.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        String role = user.getRole().toString();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return new User(username,
            user.getPassword(),
            true,
            true,
            true,
            true,
            grantedAuthorities);
    }
}