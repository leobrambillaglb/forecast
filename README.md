# Forecast Webapp

Provide a website which will return the current weather data for a city selected by the user, it should support _London_ and _Hong Kong_.
To fetch the weather data this app will use **OpenWeatherMap.org** API service.

## Overview

The site will display:
* Today's date
* City name
* Overall description of weather (i.e.: "Light rain", "Clear sky", etc)
* Temperature in Fahrenheit and Celsius
* Sunrise and sunset times in 12 hour format (i.e.: 7:35am; 7:23pm)

The styling of the website is not relevant on this first version

## Implementation

### Work plan
1. Create the base project files with Maven configuration and a simple Spring Boot app exposing a Welcome page
2. Add a Rest Controller that will return the weather data for a given city (first version can return mock data)
3. Create an OpenWeatherMap API client and connect it to the Weather controller. It will require logic to map the response from OWM to the Weather view object.
4. Add caching to reduce the calls to OWM service, there are recommendations about the data update frequency.
5. The Forecast app will provide a regular HTML page return to render the Weather data and also a REST kind endpoint to get the data in JSON format.

### Issues

Some issues that need to be tackled when implementing this app
* Display the date and time in the proper time zone. (normally Java formatter default to local-to server- timezone)
* Convert Kelvin to Fahrenheit and Celsius (used functions from Wikipedia)
* Implement the full set of objects to represent the data from OWM or just a minimal customized object to collect the required data.


## Setup

### Configurations

#### Maven 3
To make sure this project can be built with Maven 3.3, I setup the Maven Wrapper tool to use Maven 3.3.9 (latest 3.3 release)

The command to do that is
```
>$ mvn -N io.takari:maven:wrapper -Dmaven=3.3.9
```
Ref to tool: https://github.com/takari/maven-wrapper

#### Java 8
To build and run this project, Java 8 is required.

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

## Links

* OpenWeatherMap.org - https://openweathermap.org 
* About Kelvin degrees -  https://en.wikipedia.org/wiki/Kelvin