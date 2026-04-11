package com.assignment18.weather_message_app.controller;

import com.assignment18.weather_message_app.service.GreetingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for {@link WeatherController} using MockMvc.
 * This class tests the web layer without launching the full application context.
 */
@WebMvcTest(WeatherController.class)   // Specified the controller
public class WeatherControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    /**
     * Mocks the GreetingService to decouple the controller test
     * from the actual service implementation logic.
     */
    @MockitoBean
    private GreetingService greetingService;
    
    /**
     * Verifies that the GET /weather endpoint returns the expected JSON structure
     * and status code when an authenticated request is made.
     * * @throws Exception if any MVC operation fails.
     */
    @Test
    @WithMockUser   // Simulates a user to bypass Spring Security 6 default blocks
    @DisplayName("GET /weather should return 200 OK and valid JSON")
    public void testWeatherEndpoint() throws Exception {
        // Arrange: Set up the behavior of the mocked service
        String mockMessage = "Mock Weather Message";
        when(greetingService.getWeatherMessage()).thenReturn(mockMessage);
        
        // Act & Assert: Perform request and verify results
        mockMvc.perform(get("/weather"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(mockMessage))
                .andExpect(jsonPath("$.appName").exists());
    }
    
}
