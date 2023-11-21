package com.weather.weatherWebApp.controllers;

import com.weather.weatherWebApp.Repo.WeatherDataRepository;
import com.weather.weatherWebApp.models.WeatherData;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

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

    @PostMapping("/download-excel")
    public ResponseEntity<String> downloadExcel(
            @RequestParam String city,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate,
            HttpServletResponse response
    ) throws IOException {
        if (Objects.isNull(city) || Objects.isNull(startDate) || Objects.isNull(endDate)) {
            return ResponseEntity.badRequest().body("Ошибка: Заполните все поля фильтрации");
        }
        // Логика создания Excel-файла
        List<WeatherData> filteredData = weatherDataRepository.findByCityAndLastUpdateBetween(city, startDate, endDate);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Weather Data");

        // Создание заголовков
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Город");
        headerRow.createCell(1).setCellValue("Страна");
        headerRow.createCell(2).setCellValue("Температура");
        headerRow.createCell(3).setCellValue("Last Update");

        // Добавьте другие заголовки

        // Заполнение данными
        int rowNum = 1;
        for (WeatherData weatherData : filteredData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(weatherData.getCity());
            row.createCell(1).setCellValue(weatherData.getCountry());
            row.createCell(2).setCellValue(weatherData.getTemperature());

            // Установите значение lastUpdate и формат ячейки
            Cell lastUpdateCell = row.createCell(3);
            lastUpdateCell.setCellValue(java.util.Date.from(weatherData.getLastUpdate().atZone(ZoneId.systemDefault()).toInstant()));

            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd'T'HH:mm:ss"));
            lastUpdateCell.setCellStyle(dateCellStyle);

            // Заполните другие ячейки данными
        }

        // Отправка Excel-файла в ответе HTTP
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=weather_data.xlsx");

        // Запись данных в поток ответа
        workbook.write(response.getOutputStream());

        // Закрытие ресурсов
        workbook.close();
        response.getOutputStream().flush();
        return null;
    }

}

