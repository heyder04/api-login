package com.example.apilogin.service;

import com.example.apilogin.model.LoginResponse;
import com.example.apilogin.security.JwtIssuer;
import com.example.apilogin.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private  final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email,String password){
        var authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principle=(UserPrincipal) authentication.getPrincipal();
        var roles= principle.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        var token=jwtIssuer.issue(principle.getUserId(),principle.getEmail(),roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();

    }
    }
