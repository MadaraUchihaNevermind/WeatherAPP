package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.models.WeatherDataEntity;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private String city;
    private String country;
    private String temperature;
    private String feelsLike;
    private String humidity;
    private String pressure;
    private String windSpeed ;
    private String windDirection;
    private String clouds ;
    private String visibility;
    private String weatherValue;
    private String lastUpdate;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String weatherValue) {
        this.weatherValue = weatherValue;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void fetchWeatherData() {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Gomel&mode=xml&appid=a6b7d1d5a4a62495b5935f875b3ae6cf");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(connection.getInputStream());

            city = doc.getElementsByTagName("city").item(0).getAttributes().getNamedItem("name").getNodeValue();
            country = doc.getElementsByTagName("country").item(0).getTextContent();
            temperature = doc.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("value").getNodeValue();
            feelsLike = doc.getElementsByTagName("feels_like").item(0).getAttributes().getNamedItem("value").getNodeValue();
            humidity = doc.getElementsByTagName("humidity").item(0).getAttributes().getNamedItem("value").getNodeValue();
            pressure = doc.getElementsByTagName("pressure").item(0).getAttributes().getNamedItem("value").getNodeValue();
            windSpeed = doc.getElementsByTagName("speed").item(0).getAttributes().getNamedItem("value").getNodeValue();
            windDirection = doc.getElementsByTagName("direction").item(0).getAttributes().getNamedItem("value").getNodeValue();
            clouds = doc.getElementsByTagName("clouds").item(0).getAttributes().getNamedItem("value").getNodeValue();
            visibility = doc.getElementsByTagName("visibility").item(0).getAttributes().getNamedItem("value").getNodeValue();
            weatherValue = doc.getElementsByTagName("weather").item(0).getAttributes().getNamedItem("value").getNodeValue();
            lastUpdate = doc.getElementsByTagName("lastupdate").item(0).getAttributes().getNamedItem("value").getNodeValue();

            WeatherDataEntity entity = new WeatherDataEntity();
            entity.setCitydb(city);
            entity.setCountrydb(country);
            entity.setTemperaturedb(temperature);
            entity.setFeelsLikedb(feelsLike);
            entity.setHumiditydb(humidity);
            entity.setPressuredb(pressure);
            entity.setWindSpeeddb(windSpeed);
            entity.setWindDirectiondb(windDirection);
            entity.setCloudsdb(clouds);
            entity.setVisibilitydb(visibility);
            entity.setWeatherValuedb(weatherValue);
            entity.setLastUpdatedb(lastUpdate);

            weatherDataService.saveWeatherDataToDatabase(entity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}