package com.forecast.api.controller;

import com.forecast.api.model.WeatherView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;

/**
 * Main controller for Home (or Landing) page for the Web Application
 *
 * Returns Thymeleaf templates names. Check the resources/templates for the html templates.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/weather")
    public String weather(@PathParam("cityId") String cityId, Model model) {
        WeatherView weatherView = WeatherView.WeatherViewBuilder.aWeatherView()
                .withDate("Jul 28th")
                .withCityName("North Vancouver")
                .withOverallDescription("Sunny")
                .withTempC("26")
                .withTempF("86")
                .withSunrise("5:15am")
                .withSunset("9:20pm")
                .build();
        model.addAttribute("weatherView", weatherView);
        return "forecast";
    }
}
