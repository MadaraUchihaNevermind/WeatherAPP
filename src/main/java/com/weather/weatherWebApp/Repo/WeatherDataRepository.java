package com.weather.weatherWebApp.Repo;


import com.weather.weatherWebApp.models.WeatherDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {
    // Здесь можно добавить дополнительные методы для работы с данными
}
