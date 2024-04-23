package com.nikolabojanic.airbnb.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikolabojanic.airbnb.dto.AuthDtoRequest;
import com.nikolabojanic.airbnb.dto.AuthDtoResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class CredentialsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final ObjectMapper objectMapper;
    private final JwtUtils jwtUtils;

    protected CredentialsAuthenticationFilter(
        ObjectMapper objectMapper,
        @Lazy AuthenticationManager authenticationManager,
        JwtUtils jwtUtils) {
        super(new AntPathRequestMatcher("/api/v1/users/login", "POST"));
        super.setAuthenticationManager(authenticationManager);
        this.objectMapper = objectMapper;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Authentication attemptAuthentication(
        HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        InputStream requestBody = request.getInputStream();
        AuthDtoRequest authDtoRequest = objectMapper.readValue(requestBody, AuthDtoRequest.class);
        String username = authDtoRequest.getUsername();
        String password = authDtoRequest.getPassword();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            username, password);
        return super.getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getAuthorities());
        AuthDtoResponse authDtoResponse = new AuthDtoResponse(
            jwtUtils.buildToken(claims, user, jwtUtils.getJwtExpiration()));
        String jsonResponse = objectMapper.writeValueAsString(authDtoResponse);
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }
}
