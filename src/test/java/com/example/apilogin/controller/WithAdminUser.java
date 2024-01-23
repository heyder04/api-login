package com.example.apilogin.controller;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME )
@WithMockUser(authorities = "ROLE_ADMIN")
public @interface WithAdminUser {
    long userId() default 1L;


}
