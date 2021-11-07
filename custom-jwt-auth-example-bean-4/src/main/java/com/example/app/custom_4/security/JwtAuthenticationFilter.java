package com.example.app.custom_4.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * If I declare a filter class that is successor of {@link javax.servlet.Filter} as a Spring bean then Spring wraps it with
 * {@link org.springframework.boot.web.servlet.RegistrationBean} in the
 * {@link org.springframework.boot.web.servlet.ServletContextInitializerBeans#addAsRegistrationBean} method.
 * {@link org.springframework.boot.web.servlet.RegistrationBean} is {@link org.springframework.boot.web.servlet.ServletContextInitializer}.
 * Spring calls onStartup methods for beans of that type in the {@link org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext#selfInitialize}
 * In the onStartup method occurs servlet container registration
 */
//@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        // Retrieve token from headers
        // ...
        // ...
        // Do everything in the filter and don't use providers

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                "user",
                "password",
                null
        );

        SecurityContextHolder.getContext().setAuthentication(token);

        filterChain.doFilter(request, response);
    }
}
