package HomeWork6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        String api_key_value = "GTuooaBjQULRc3mdhH6U9gALZYiliABS";
        String api_key_name = "apikey";
        String forecasts = "forecasts";
        String version = "v1";
        String daily = "daily";
        String days = "5day";
        String city = "123";

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment(forecasts)
                .addPathSegment(version)
                .addPathSegment(daily)
                .addPathSegment(days)
                .addPathSegment(city)
                .addQueryParameter(api_key_name, api_key_value)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient
                .newCall(request)
                .execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(request.url());
        System.out.println(response.body().string());
    }
}
