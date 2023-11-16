package com.weather.weatherWebApp.services;
import com.weather.weatherWebApp.Repo.WeatherDataRepository;
import com.weather.weatherWebApp.models.WeatherData;
import com.weather.weatherWebApp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherDataService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public void saveWeatherDataFromXML(WeatherService weatherService) throws IOException, ParserConfigurationException, SAXException {
        weatherService.fetchWeatherData();

        // Проверка наличия данных в базе данных
        if (!isWeatherDataAlreadyExists(weatherService)) {
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
            LocalDateTime lastUpdate = LocalDateTime.parse(weatherService.getLastUpdate(), formatter);
            weatherData.setLastUpdate(lastUpdate);

            // Сохранение данных в базу данных с использованием репозитория
            weatherDataRepository.save(weatherData);
        } else {
            // Логика для случая, когда данные уже существуют в базе данных
            System.out.println("Данные уже существуют в базе данных");
        }
    }

    private boolean isWeatherDataAlreadyExists(WeatherService weatherService) {
        // Проверка наличия данных в базе данных по городу, стране и lastUpdate
        return weatherDataRepository.existsByCityAndCountryAndLastUpdate(
                weatherService.getCity(),
                weatherService.getCountry(),
                LocalDateTime.parse(weatherService.getLastUpdate(), formatter)
        );
    }
}