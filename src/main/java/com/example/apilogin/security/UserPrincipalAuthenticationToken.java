package com.example.apilogin.security;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Builder
@Getter
public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {
 public final UserPrincipal principal;
    public UserPrincipalAuthenticationToken(UserPrincipal principal) {
     super(principal.getAuthorities());
     this.principal =principal;
     setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return principal;
    }
}
