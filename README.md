# Forecast Webapp
Provide a website which will return the current weather data for a city selected by the user, it should support _London_ and _Hong Kong_.
To fetch the weather data this app will use **OpenWeatherMap.org** API service.

The site will display:
- Today's date
- City name
- Overall description of weather (i.e.: "Light rain", "Clear sky", etc)
- Temperature in Fahrenheit and Celsius
- Sunrise and sunset times in 12 hour format (i.e.: 7:35am; 7:23pm)

The styling of the website is not relevant on this first version

Work plan:
1. Create the base project files with Maven configuration and a simple Spring Boot app exposing a Welcome page
2. Add a Rest Controller that will return the weather data for a given city (first version can return mock data)
3. Create an OpenWeatherMap API client and connect it to the Weather controller. It will require logic to map the response from OWM to the Weather view object.
4. Add caching to reduce the calls to OWM service, there are recommendations about the data update frequency.
5. The Forecast app will provide a regular HTML page return to render the Weather data and also a REST kind endpoint to get the data in JSON format.

### Deploy and run

**Development**

From the project's root dir:
```
>$ ./mvnw spring-boot:run
```

**Production**

_Build_

mvn package ...

_Run_

java -jar something..
