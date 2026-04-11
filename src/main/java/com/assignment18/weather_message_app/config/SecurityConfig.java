package com.assignment18.weather_message_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for the application.
 * Defines access rules for REST endpoints using Spring Security 6.
 * DESIGN DECISION: This application follows a "Public-First" approach for weather data,
 *                   ensuring that the primary weather API is accessible without authentication
 *                   to maximize reach and usability.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    /**
     * Configures the HTTP security filter chain.
     *
     * @param http The HttpSecurity object to build the configuration.
     * @return The built SecurityFilterChain.
     * @throws Exception if configuration fails.
     */
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                // Stateless API: CSRF is disabled as we are not using session-based authentication
                .csrf(csrf -> csrf.disable())
                
                .authorizeHttpRequests(auth -> auth
                        // PUBLIC ACCESS: Explicitly permit all traffic to the weather endpoint
                        .requestMatchers("/weather").permitAll()
                        
                        // INTERNAL/PRIVATE: All other potential administrative or internal routes require login
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
