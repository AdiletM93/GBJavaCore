package HomeWork8;

import HomeWork8.entity.WeatherDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "GTuooaBjQULRc3mdhH6U9gALZYiliABS";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DatabaseRepository databaseRepository = new DatabaseRepository();
    DailyForecast date = new DailyForecast();
    Maximum value = new Maximum();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                Weather WeatherFromResponse = objectMapper.readValue(weatherResponse, Weather.class);
                System.out.println("В городе " + selectedCity + ": " + WeatherFromResponse);

                try {
                    databaseRepository.saveWeatherToDB(new WeatherDB(selectedCity, date.getDate(), value.getValue()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case FIVE_DAYS:
                HttpUrl httpUrl2 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request2 = new Request.Builder()
                        .url(httpUrl2)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request2).execute();
                String weatherResponse2 = fiveDayForecastResponse.body().string();
                Weather WeatherFromResponse2 = objectMapper.readValue(weatherResponse2, Weather.class);
                System.out.println("В городе " + selectedCity + ": " + WeatherFromResponse2);


                //String date2 = objectMapper.readTree(weatherResponse2).get(1).at("/Date").asText();
                //Double temperature2 = Double.valueOf(objectMapper.readTree(weatherResponse2).get(1).at("/Unit").asText());
                //databaseRepository.saveWeatherToDB(new List<WeatherDB>());
                break;
            case DB:
                databaseRepository.getSavedToDBWeather();
        }
    }

    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

    @Override
    public List<WeatherDB> getSavedToDBWeather() {
        return databaseRepository.getSavedToDBWeather();
    }

    public static void main(String[] args) throws SQLException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
        DatabaseRepository databaseRepository = new DatabaseRepository();
        System.out.println(databaseRepository.getSavedToDBWeather());
    }
}