package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.services.WeatherDataService;
import com.weather.weatherWebApp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/weather")
    public String showWeather(Model model) throws IOException, ParserConfigurationException, SAXException {
        WeatherService weatherServiceGomel = new WeatherService("Gomel");
        weatherServiceGomel.fetchWeatherData();// Вызываем метод для получения данных о погоде
        WeatherService weatherServiceMinks = new WeatherService("Minsk");
        weatherServiceMinks.fetchWeatherData();


        // Получение данных из WeatherService
        String[] city = new String[7];
        city[0] = weatherServiceGomel.getCity();
        city[1] = weatherServiceMinks.getCity();


        String[] country = new String[7];
        country[0] = weatherServiceGomel.getCountry();
        country[2] = weatherServiceMinks.getCountry();

        String[] temperature = new String[7];
        temperature[0] = weatherServiceGomel.getTemperature();
        temperature[1] = weatherServiceMinks.getTemperature();

        String[] feelsLike = new String[7];
        feelsLike[0] = weatherServiceGomel.getFeelsLike();
        feelsLike[1] = weatherServiceMinks.getFeelsLike();

        String[] humidity = new String[7];
        humidity[0] = weatherServiceGomel.getHumidity();
        humidity[1] = weatherServiceMinks.getHumidity();

        String[] pressure = new String[7];
        pressure[0] = weatherServiceGomel.getPressure();
        pressure[1] = weatherServiceMinks.getPressure();

        String[] windSpeed = new String[7];
        windSpeed[0] = weatherServiceGomel.getWindSpeed();
        windSpeed[1] = weatherServiceMinks.getWindSpeed();

        String[] windDirection = new String[7];
        windDirection[0] = weatherServiceGomel.getWindDirection();
        windDirection[1] = weatherServiceMinks.getWindDirection();

        String[] clouds = new String[7];
        clouds[0] = weatherServiceGomel.getClouds();
        clouds[1] = weatherServiceMinks.getClouds();


        String[] visibility = new String[7];
        visibility[0] = weatherServiceGomel.getVisibility();
        visibility[1] = weatherServiceMinks.getVisibility();

        String[] weatherValue = new String[7];
        weatherValue[0] = weatherServiceGomel.getWeatherValue();
        weatherValue[1] = weatherServiceMinks.getWeatherValue();

        String[] lastUpdate = new String[7];
        lastUpdate[0] = weatherServiceGomel.getLastUpdate();
        lastUpdate[1] = weatherServiceMinks.getLastUpdate();


        weatherDataService.saveWeatherDataFromXML(weatherServiceGomel);

        // Передача данных на страницу
        model.addAttribute("city", city[0]);
        model.addAttribute("country", country[0]);
        model.addAttribute("temperature", temperature[0]);
        model.addAttribute("feelsLike", feelsLike[0]);
        model.addAttribute("humidity", humidity[0]);
        model.addAttribute("pressure", pressure[0]);
        model.addAttribute("windSpeed", windSpeed[0]);
        model.addAttribute("windDirection", windDirection[0]);
        model.addAttribute("clouds", clouds[0]);
        model.addAttribute("visibility", visibility[0]);
        model.addAttribute("weatherValue", weatherValue[0]);
        model.addAttribute("lastUpdate", lastUpdate[0]);

        model.addAttribute("city1", city[1]);
        model.addAttribute("country1", country[1]);
        model.addAttribute("temperature1", temperature[1]);
        model.addAttribute("feelsLike1", feelsLike[1]);
        model.addAttribute("humidity1", humidity[1]);
        model.addAttribute("pressure1", pressure[1]);
        model.addAttribute("windSpeed1", windSpeed[1]);
        model.addAttribute("windDirection1", windDirection[1]);
        model.addAttribute("clouds1", clouds[1]);
        model.addAttribute("visibility1", visibility[1]);
        model.addAttribute("weatherValue1", weatherValue[1]);
        model.addAttribute("lastUpdate1", lastUpdate[1]);


        return "weather"; // Предполагая, что у вас есть файл weather.html для отображения данных
    }
}