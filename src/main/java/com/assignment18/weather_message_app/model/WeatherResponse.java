package com.assignment18.weather_message_app.model;

/**
 * An immutable Data Transfer Object (DTO) used for the API response.
 * Uses Java Records for concise, thread-safe data handling.
 * * @param appName The display name of the application.
 *
 * @param message The seasonal greeting message.
 */
public record WeatherResponse(
        String appName,
        String message
) {
}
