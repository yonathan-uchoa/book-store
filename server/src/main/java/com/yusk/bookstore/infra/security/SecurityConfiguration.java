package com.yusk.bookstore.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sound.midi.Patch;
import java.nio.file.Path;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize

                        //Client requests
                        .requestMatchers(HttpMethod.POST, "/client").permitAll()
                        .requestMatchers(HttpMethod.GET, "/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/client/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/client/**").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/client/**").hasRole("ADMIN")
                        // Book requests
                        .requestMatchers(HttpMethod.GET, "/library").permitAll()
                        .requestMatchers(HttpMethod.GET, "/library/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/library/online").permitAll()
                        .requestMatchers(HttpMethod.POST, "/library").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/library/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/library/**").hasRole("MANAGER")
                        // Wish List request
                        .requestMatchers(HttpMethod.GET, "/wishlist").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/wishlist/**").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.POST, "/wishlist").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.PUT, "/wishlist/**").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.PUT, "/wishlist/**/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/wishlist/**").hasRole("ADMIN")
                        // Address request
                        .requestMatchers(HttpMethod.GET, "/address/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/address/**").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.PUT, "/address/**").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/address/**").hasRole("CLIENT")
                        .requestMatchers("/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html").permitAll()
                        // Auth request
                        .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
