package com.assignment18.weather_message_app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests to verify Spring Profile configuration.
 * Ensures that the 'summer' profile correctly wires the appropriate greeting bean.
 */
@SpringBootTest
@ActiveProfiles("summer")   // Explicitly activates the summer profile for this test class
public class WeatherProfileIntegrationTest {
    
    /**
     * The GreetingService bean injected here is determined by the @ActiveProfiles annotation.
     */
    @Autowired
    private GreetingService greetingService;
    
    /**
     * Validates that the application context loads the correct message
     * from 'application-summer.properties'.
     */
    @Test
    public void shouldLoadSummerMessage() {
        // Act
        String message = greetingService.getWeatherMessage();
        
        // Assert: Verify that the message matches the expected output for the summer profile
        assertThat(message)
                .as("The summer profile message should focus on staying hydrated.")
                .isEqualTo("It's sunny outside! Stay hydrated.");
    }
}
