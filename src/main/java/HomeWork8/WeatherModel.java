package HomeWork8;

import HomeWork8.entity.WeatherDB;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;

    List<WeatherDB> getSavedToDBWeather();
}