package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.Repo.WeatherDataRepository;
import com.weather.weatherWebApp.models.WeatherDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {

    private final WeatherDataRepository weatherDataRepository;

    @Autowired
    public WeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public void saveWeatherDataToDatabase(String city, String country, String temperature, String feelsLike, String humidity, String pressure, String windSpeed, String windDirection, String clouds, String visibility, String weatherValue, String lastUpdate) {
        WeatherDataEntity weatherDataEntity = new WeatherDataEntity();
        weatherDataEntity.setCitydb(city);
        weatherDataEntity.setCountrydb(country);
        weatherDataEntity.setTemperaturedb(temperature);
        weatherDataEntity.setFeelsLikedb(feelsLike);
        weatherDataEntity.setHumiditydb(humidity);
        weatherDataEntity.setPressuredb(pressure);
        weatherDataEntity.setWindSpeeddb(windSpeed);
        weatherDataEntity.setWindDirectiondb(windDirection);
        weatherDataEntity.setCloudsdb(clouds);
        weatherDataEntity.setVisibilitydb(visibility);
        weatherDataEntity.setWeatherValuedb(weatherValue);
        weatherDataEntity.setLastUpdatedb(lastUpdate);
        // Задать остальные данные

        weatherDataRepository.save(weatherDataEntity);
    }
}
