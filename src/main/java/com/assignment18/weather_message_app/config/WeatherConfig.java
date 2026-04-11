package com.assignment18.weather_message_app.config;

import com.assignment18.weather_message_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration class responsible for Bean creation based on active profiles.
 * It uses conditional bean registration to swap the GreetingService implementation.
 */
@Configuration
public class WeatherConfig {
    
    @Value("${app.message}")
    private String message;
    
    /**
     * Active only when the 'summer' profile is enabled.
     *
     * @return GreetingService implementation returning summer-themed text.
     */
    @Bean
    @Profile("summer")
    public GreetingService summerGreetingService () {
        return () -> message;
    }
    
    /**
     * Active only when the 'winter' profile is enabled.
     *
     * @return GreetingService implementation returning winter-themed text.
     */
    @Bean
    @Profile("winter")
    public GreetingService winterGreetingService () {
        return () -> message;
    }
    
}
