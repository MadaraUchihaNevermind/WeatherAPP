package com.weather.weatherWebApp.Repo;

import com.weather.weatherWebApp.models.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    // Определите дополнительные методы, если необходимо
}
