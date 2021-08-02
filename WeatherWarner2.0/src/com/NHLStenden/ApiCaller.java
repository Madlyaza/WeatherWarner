package com.NHLStenden;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCaller
{
    public String getWeather(String location)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/find?q="+ location +"&cnt=1&mode=XML&lon=0&type=link%2C%20accurate&lat=0&units=metric"))
                .header("x-rapidapi-key", "e0f745ce19mshde257cf3b9d08bcp15b392jsnae76ad93ec4d")
                .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return(response.body());
    }

//    public String getForecastThreeHours()
//    {
//
//    }
}
