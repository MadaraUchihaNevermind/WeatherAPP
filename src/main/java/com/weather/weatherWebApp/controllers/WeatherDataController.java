package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.Repo.WeatherDataRepository;
import com.weather.weatherWebApp.models.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class WeatherDataController {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @GetMapping("/weatherData")
    public String showWeatherData(Model model) {
        // Получение списка данных из базы данных
        model.addAttribute("weatherDataList", weatherDataRepository.findAll());
        return "weatherData";
    }
    @GetMapping("/filter")
    public String filterWeatherDataByCityAndPeriod(
            @RequestParam String city,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime endDate,
            Model model
    ) {
        List<WeatherData> filteredData = weatherDataRepository.findByCityAndLastUpdateBetween(city, startDate, endDate);

        model.addAttribute("weatherDataList", filteredData);
        model.addAttribute("cityFilter", city);
        model.addAttribute("startDateFilter", startDate);
        model.addAttribute("endDateFilter", endDate);

        return "weatherData";
    }
}
