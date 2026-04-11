package com.assignment18.weather_message_app.service;

/**
 * Functional interface for weather greeting logic.
 * This allows for different implementations based on active Spring Profiles.
 */
public interface GreetingService {
    /**
     * Retrieves the weather-themed welcome message.
     *
     * @return A string containing the seasonal message.
     */
    String getWeatherMessage ();
}
