package com.weather.weatherWebApp;

import com.weather.weatherWebApp.controllers.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class WeatherWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherWebAppApplication.class, args);
	}
}

