package com.NHLStenden;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// The class that handles the API calls to the Open Weather Map API
public class ApiCaller
{
    // Gets the forecast for the next three hours filtered on location and writes it to XmlParsing.xml
    public void getForecastThreeHours(String location)
    {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://community-open-weather-map.p.rapidapi.com/forecast?q=" + location + "%2Cnl&units=metric&mode=xml&lang=en&cnt=2")).header("x-rapidapi-key", "e0f745ce19mshde257cf3b9d08bcp15b392jsnae76ad93ec4d").header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            File myObj = new File("XmlParsing.xml");
            myObj.createNewFile();
        } catch (IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        try
        {
            FileWriter myWriter = new FileWriter("XmlParsing.xml");
            myWriter.write(response.body());
            myWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Gets the forecast for the next day filtered on location and writes it to XmlParsing.xml
    public void getForecastOneDay(String location)
    {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://community-open-weather-map.p.rapidapi.com/forecast/daily?q=" + location + "%2Cnl&cnt=2&units=metric&mode=xml&lang=en")).header("x-rapidapi-key", "5d1ef61c7bmsh6cab727049436a9p129bacjsn253a9721df76").header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            File myObj = new File("XmlParsing.xml");
            myObj.createNewFile();
        } catch (IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        try
        {
            FileWriter myWriter = new FileWriter("XmlParsing.xml");
            myWriter.write(response.body());
            myWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Gets the forecast for the next ten days filtered on location and writes it to XmlParsing.xml
    public void getNextTenDays(String location)
    {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://community-open-weather-map.p.rapidapi.com/forecast/daily?q=" + location + "%2Cnl&cnt=11&units=metric&mode=xml&lang=en")).header("x-rapidapi-key", "5d1ef61c7bmsh6cab727049436a9p129bacjsn253a9721df76").header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            File myObj = new File("XmlParsing.xml");
            myObj.createNewFile();
        } catch (IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        try
        {
            FileWriter myWriter = new FileWriter("XmlParsing.xml");
            myWriter.write(response.body());
            myWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
