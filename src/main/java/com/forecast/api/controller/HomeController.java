package com.forecast.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller for Home (or Landing) page for the Web Application
 *
 * Returns Thymeleaf templates names. Check the resources/templates for the html templates.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        return "homepage";
    }
}
