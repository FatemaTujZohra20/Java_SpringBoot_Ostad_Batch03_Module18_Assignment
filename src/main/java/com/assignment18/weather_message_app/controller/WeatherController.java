package com.assignment18.weather_message_app.controller;

import com.assignment18.weather_message_app.model.WeatherResponse;
import com.assignment18.weather_message_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller providing access to weather-themed greetings.
 */
@RestController
public class WeatherController {
    
    private final GreetingService greetingService;
    
    @Value("${app.name}")
    private String appName;
    
    /**
     * Constructor-based Dependency Injection.
     *
     * @param greetingService The profile-specific bean injected by Spring.
     */
    public WeatherController (GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    /**
     * GET /weather endpoint.
     *
     * @return A WeatherResponse containing the application name and the seasonal message.
     */
    @GetMapping("/weather")
    public WeatherResponse getWeather () {
        return new WeatherResponse(appName, greetingService.getWeatherMessage());
    }
}
