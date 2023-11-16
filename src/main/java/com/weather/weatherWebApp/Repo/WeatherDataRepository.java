package com.weather.weatherWebApp.Repo;

import com.weather.weatherWebApp.models.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    boolean existsByCityAndCountryAndLastUpdate(String city, String country, LocalDateTime lastUpdate);
    List<WeatherData> findByCityAndLastUpdateBetween(String city, LocalDateTime startDate, LocalDateTime endDate);
}
