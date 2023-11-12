package com.weather.weatherWebApp.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class WeatherDataEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String citydb;
    private String countrydb;
    private String temperaturedb;
    private String feelsLikedb;
    private String humiditydb;
    private String pressuredb ;
    private String windSpeeddb ;
    private String windDirectiondb;
    private String cloudsdb ;
    private String visibilitydb ;
    private String weatherValuedb;
    private String lastUpdatedb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCitydb() {
        return citydb;
    }

    public void setCitydb(String citydb) {
        this.citydb = citydb;
    }

    public String getCountrydb() {
        return countrydb;
    }

    public void setCountrydb(String countrydb) {
        this.countrydb = countrydb;
    }

    public String getTemperaturedb() {
        return temperaturedb;
    }

    public void setTemperaturedb(String temperaturedb) {
        this.temperaturedb = temperaturedb;
    }

    public String getFeelsLikedb() {
        return feelsLikedb;
    }

    public void setFeelsLikedb(String feelsLikedb) {
        this.feelsLikedb = feelsLikedb;
    }

    public String getHumiditydb() {
        return humiditydb;
    }

    public void setHumiditydb(String humiditydb) {
        this.humiditydb = humiditydb;
    }

    public String getPressuredb() {
        return pressuredb;
    }

    public void setPressuredb(String pressuredb) {
        this.pressuredb = pressuredb;
    }

    public String getWindSpeeddb() {
        return windSpeeddb;
    }

    public void setWindSpeeddb(String windSpeeddb) {
        this.windSpeeddb = windSpeeddb;
    }

    public String getWindDirectiondb() {
        return windDirectiondb;
    }

    public void setWindDirectiondb(String windDirectiondb) {
        this.windDirectiondb = windDirectiondb;
    }

    public String getCloudsdb() {
        return cloudsdb;
    }

    public void setCloudsdb(String cloudsdb) {
        this.cloudsdb = cloudsdb;
    }

    public String getVisibilitydb() {
        return visibilitydb;
    }

    public void setVisibilitydb(String visibilitydb) {
        this.visibilitydb = visibilitydb;
    }

    public String getWeatherValuedb() {
        return weatherValuedb;
    }

    public void setWeatherValuedb(String weatherValuedb) {
        this.weatherValuedb = weatherValuedb;
    }

    public String getLastUpdatedb() {
        return lastUpdatedb;
    }

    public void setLastUpdatedb(String lastUpdatedb) {
        this.lastUpdatedb = lastUpdatedb;
    }

    // Пустой конструктор и конструктор с параметрами
}
