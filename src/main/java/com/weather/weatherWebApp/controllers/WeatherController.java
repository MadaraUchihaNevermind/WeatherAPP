package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.controllers.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String showWeather(Model model) {
        WeatherService weatherService = new WeatherService();
        weatherService.fetchWeatherData(); // Вызываем метод для получения данных о погоде

        // Получение данных из WeatherService
        String city = weatherService.getCity();
        String country = weatherService.getCountry();
        String temperature = weatherService.getTemperature();
        String feelsLike = weatherService.getFeelsLike();
        String humidity = weatherService.getHumidity();
        String pressure = weatherService.getPressure();
        String windSpeed = weatherService.getWindSpeed();
        String windDirection = weatherService.getWindDirection();
        String clouds = weatherService.getClouds();
        String visibility = weatherService.getVisibility();
        String weatherValue = weatherService.getWeatherValue();
        String lastUpdate = weatherService.getLastUpdate();

        // Передача данных на страницу
        model.addAttribute("city", city);
        model.addAttribute("country", country);
        model.addAttribute("temperature", temperature);
        model.addAttribute("feelsLike", feelsLike);
        model.addAttribute("humidity", humidity);
        model.addAttribute("pressure", pressure);
        model.addAttribute("windSpeed", windSpeed);
        model.addAttribute("windDirection", windDirection);
        model.addAttribute("clouds", clouds);
        model.addAttribute("visibility", visibility);
        model.addAttribute("weatherValue", weatherValue);
        model.addAttribute("lastUpdate", lastUpdate);

        return "weather"; // Предполагая, что у вас есть файл weather.html для отображения данных
    }
}