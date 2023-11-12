package com.weather.weatherWebApp.controllers;
import com.weather.weatherWebApp.Repo.WeatherDataRepository;
import com.weather.weatherWebApp.models.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

@Service
public class WeatherDataService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    public void saveWeatherDataFromXML(WeatherService weatherService) throws IOException, ParserConfigurationException, SAXException {
        weatherService.fetchWeatherData();

        WeatherData weatherData = new WeatherData();
        weatherData.setCity(weatherService.getCity());
        weatherData.setCountry(weatherService.getCountry());
        weatherData.setTemperature(weatherService.getTemperature());

        weatherData.setFeelsLike(weatherService.getFeelsLike());
        weatherData.setHumidity(weatherService.getHumidity());
        weatherData.setPressure(weatherService.getPressure());

        weatherData.setWindSpeed(weatherService.getWindSpeed());
        weatherData.setWindDirection(weatherService.getWindDirection());
        weatherData.setClouds(weatherService.getClouds());

        weatherData.setVisibility(weatherService.getVisibility());
        weatherData.setWeatherValue(weatherService.getWeatherValue());
        weatherData.setLastUpdate(weatherService.getLastUpdate());
        // Установи другие свойства

        // Сохранение данных в базу данных с использованием репозитория
        weatherDataRepository.save(weatherData);
    }
}