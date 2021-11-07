package com.example.app.custom_2.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("JwtAuthenticationProvider was called");

        // validate token
        // ...
        // ...

        // from the Authentication javadoc:
        // Note that unless the Authentication has the authenticated property set to true, it will still be authenticated by any security interceptor (for method or web invocations) which encounters it.
        // In most cases, the framework transparently takes care of managing the security context and authentication objects for you.
        authentication.setAuthenticated(true);
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
