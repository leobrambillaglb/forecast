package com.forecast.api.owm;

import com.forecast.api.model.Weather;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * OpenWeatherMap API client
 */
@Component
public class OpenWeatherMapClient {

    // TODO these values could be moved to the properties file
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?id={id}&appid={appId}";
    private static final String apiKey = "8d59c9119b571c7205eb6a1467920a97";

    private final RestTemplate restTemplate;

    public OpenWeatherMapClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    public Weather fetchWeatherByCityId(String id) {
        // TODO: handle errors from calling API? Like 401 - Unauthorized ?
        ResponseEntity<String> weatherData = this.restTemplate.getForEntity(API_URL, String.class, id, apiKey);
        String jsonString = weatherData.getBody();
        System.out.println(jsonString);
        return createFromJsonString(jsonString);
    }

    private Weather createFromJsonString(String jsonString) {
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);
        Integer date = JsonPath.read(document, "$.dt");
        String cityName = JsonPath.read(document, "$.name");
        String description = JsonPath.read(document, "$.weather[0].description");
        Double temperature = JsonPath.read(document, "$.main.temp");
        Integer sunrise = JsonPath.read(document, "$.sys.sunrise");
        Integer sunset = JsonPath.read(document, "$.sys.sunset");
        return new Weather((long) date, cityName, description, temperature, (long) sunrise, (long) sunset);
    }
}
