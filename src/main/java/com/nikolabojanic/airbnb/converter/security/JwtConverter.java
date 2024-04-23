package com.nikolabojanic.airbnb.converter.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter implements Converter<Jwt, JwtAuthenticationToken> {
    @Override
    public JwtAuthenticationToken convert(Jwt jwt) {
        Collection<SimpleGrantedAuthority> authorities = jwt.getClaimAsStringList("roles").stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        return new JwtAuthenticationToken(jwt, authorities);
    }
}