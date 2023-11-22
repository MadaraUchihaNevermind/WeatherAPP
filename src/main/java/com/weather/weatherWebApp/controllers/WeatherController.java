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

        WeatherService weatherServiceBrest = new WeatherService("Brest");
        weatherServiceBrest.fetchWeatherData();

        WeatherService weatherServiceVitebsk = new WeatherService("Vitebsk");
        weatherServiceVitebsk.fetchWeatherData();

        WeatherService weatherServiceMogilev = new WeatherService("Mogilev");
        weatherServiceMogilev.fetchWeatherData();

        WeatherService weatherServiceGrodno = new WeatherService("Grodno");
        weatherServiceGrodno.fetchWeatherData();


        // Получение данных из WeatherService
        String[] city = new String[7];
        city[0] = weatherServiceGomel.getCity();
        city[1] = weatherServiceMinks.getCity();
        city[2] = weatherServiceBrest.getCity();
        city[3] = weatherServiceVitebsk.getCity();
        city[4] = weatherServiceMogilev.getCity();
        city[5] = weatherServiceGrodno.getCity();


        String[] country = new String[7];
        country[0] = weatherServiceGomel.getCountry();
        country[1] = weatherServiceMinks.getCountry();
        country[2] = weatherServiceBrest.getCountry();
        country[3] = weatherServiceVitebsk.getCountry();
        country[4] = weatherServiceMogilev.getCountry();
        country[5] = weatherServiceGrodno.getCountry();

        String[] temperature = new String[7];
        temperature[0] = weatherServiceGomel.getTemperature();
        temperature[1] = weatherServiceMinks.getTemperature();
        temperature[2] = weatherServiceBrest.getTemperature();
        temperature[3] = weatherServiceVitebsk.getTemperature();
        temperature[4] = weatherServiceMogilev.getTemperature();
        temperature[5] = weatherServiceGrodno.getTemperature();

        String[] feelsLike = new String[7];
        feelsLike[0] = weatherServiceGomel.getFeelsLike();
        feelsLike[1] = weatherServiceMinks.getFeelsLike();
        feelsLike[2] = weatherServiceBrest.getFeelsLike();
        feelsLike[3] = weatherServiceVitebsk.getFeelsLike();
        feelsLike[4] = weatherServiceMogilev.getFeelsLike();
        feelsLike[5] = weatherServiceGrodno.getFeelsLike();

        String[] humidity = new String[7];
        humidity[0] = weatherServiceGomel.getHumidity();
        humidity[1] = weatherServiceMinks.getHumidity();
        humidity[2] = weatherServiceBrest.getHumidity();
        humidity[3] = weatherServiceVitebsk.getHumidity();
        humidity[4] = weatherServiceMogilev.getHumidity();
        humidity[5] = weatherServiceGrodno.getHumidity();


        String[] pressure = new String[7];
        pressure[0] = weatherServiceGomel.getPressure();
        pressure[1] = weatherServiceMinks.getPressure();
        pressure[2] = weatherServiceBrest.getPressure();
        pressure[3] = weatherServiceVitebsk.getPressure();
        pressure[4] = weatherServiceMogilev.getPressure();
        pressure[5] = weatherServiceGrodno.getPressure();

        String[] windSpeed = new String[7];
        windSpeed[0] = weatherServiceGomel.getWindSpeed();
        windSpeed[1] = weatherServiceMinks.getWindSpeed();
        windSpeed[2] = weatherServiceBrest.getWindSpeed();
        windSpeed[3] = weatherServiceVitebsk.getWindSpeed();
        windSpeed[4] = weatherServiceMogilev.getWindSpeed();
        windSpeed[5] = weatherServiceGrodno.getWindSpeed();

        String[] windDirection = new String[7];
        windDirection[0] = weatherServiceGomel.getWindDirection();
        windDirection[1] = weatherServiceMinks.getWindDirection();
        windDirection[2] = weatherServiceBrest.getWindDirection();
        windDirection[3] = weatherServiceVitebsk.getWindDirection();
        windDirection[4] = weatherServiceMogilev.getWindDirection();
        windDirection[5] = weatherServiceGrodno.getWindDirection();

        String[] clouds = new String[7];
        clouds[0] = weatherServiceGomel.getClouds();
        clouds[1] = weatherServiceMinks.getClouds();
        clouds[2] = weatherServiceBrest.getClouds();
        clouds[3] = weatherServiceVitebsk.getClouds();
        clouds[4] = weatherServiceMogilev.getClouds();
        clouds[5] = weatherServiceGrodno.getClouds();


        String[] visibility = new String[7];
        visibility[0] = weatherServiceGomel.getVisibility();
        visibility[1] = weatherServiceMinks.getVisibility();
        visibility[2] = weatherServiceBrest.getVisibility();
        visibility[3] = weatherServiceVitebsk.getVisibility();
        visibility[4] = weatherServiceMogilev.getVisibility();
        visibility[5] = weatherServiceGrodno.getVisibility();

        String[] weatherValue = new String[7];
        weatherValue[0] = weatherServiceGomel.getWeatherValue();
        weatherValue[1] = weatherServiceMinks.getWeatherValue();
        weatherValue[2] = weatherServiceBrest.getWeatherValue();
        weatherValue[3] = weatherServiceVitebsk.getWeatherValue();
        weatherValue[4] = weatherServiceMogilev.getWeatherValue();
        weatherValue[5] = weatherServiceGrodno.getWeatherValue();

        String[] lastUpdate = new String[7];
        lastUpdate[0] = weatherServiceGomel.getLastUpdate();
        lastUpdate[1] = weatherServiceMinks.getLastUpdate();
        lastUpdate[2] = weatherServiceBrest.getLastUpdate();
        lastUpdate[3] = weatherServiceVitebsk.getLastUpdate();
        lastUpdate[4] = weatherServiceMogilev.getLastUpdate();
        lastUpdate[5] = weatherServiceGrodno.getLastUpdate();


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

        model.addAttribute("city2", city[2]);
        model.addAttribute("country2", country[2]);
        model.addAttribute("temperature2", temperature[2]);
        model.addAttribute("feelsLike2", feelsLike[2]);
        model.addAttribute("humidity2", humidity[2]);
        model.addAttribute("pressure2", pressure[2]);
        model.addAttribute("windSpeed2", windSpeed[2]);
        model.addAttribute("windDirection2", windDirection[2]);
        model.addAttribute("clouds2", clouds[2]);
        model.addAttribute("visibility2", visibility[2]);
        model.addAttribute("weatherValue2", weatherValue[2]);
        model.addAttribute("lastUpdate2", lastUpdate[2]);

        model.addAttribute("city3", city[3]);
        model.addAttribute("country3", country[3]);
        model.addAttribute("temperature3", temperature[3]);
        model.addAttribute("feelsLike3", feelsLike[3]);
        model.addAttribute("humidity3", humidity[3]);
        model.addAttribute("pressure3", pressure[3]);
        model.addAttribute("windSpeed3", windSpeed[3]);
        model.addAttribute("windDirection3", windDirection[3]);
        model.addAttribute("clouds3", clouds[3]);
        model.addAttribute("visibility3", visibility[3]);
        model.addAttribute("weatherValue3", weatherValue[3]);
        model.addAttribute("lastUpdate3", lastUpdate[3]);

        model.addAttribute("city4", city[4]);
        model.addAttribute("country4", country[4]);
        model.addAttribute("temperature4", temperature[4]);
        model.addAttribute("feelsLike4", feelsLike[4]);
        model.addAttribute("humidity4", humidity[4]);
        model.addAttribute("pressure4", pressure[4]);
        model.addAttribute("windSpeed4", windSpeed[4]);
        model.addAttribute("windDirection4", windDirection[4]);
        model.addAttribute("clouds4", clouds[4]);
        model.addAttribute("visibility4", visibility[4]);
        model.addAttribute("weatherValue4", weatherValue[4]);
        model.addAttribute("lastUpdate4", lastUpdate[4]);

        model.addAttribute("city5", city[5]);
        model.addAttribute("country5", country[5]);
        model.addAttribute("temperature5", temperature[5]);
        model.addAttribute("feelsLike5", feelsLike[5]);
        model.addAttribute("humidity5", humidity[5]);
        model.addAttribute("pressure5", pressure[5]);
        model.addAttribute("windSpeed5", windSpeed[5]);
        model.addAttribute("windDirection5", windDirection[5]);
        model.addAttribute("clouds5", clouds[5]);
        model.addAttribute("visibility5", visibility[5]);
        model.addAttribute("weatherValue5", weatherValue[5]);
        model.addAttribute("lastUpdate5", lastUpdate[5]);

        return "weather"; // Предполагая, что у вас есть файл weather.html для отображения данных
    }
}