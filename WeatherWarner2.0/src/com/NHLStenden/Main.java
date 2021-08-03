package com.NHLStenden;

public class Main {

    public static void main(String[] args)
    {
        User user = new User("Admin", "Emmen");
        ApiCaller api = new ApiCaller();
        System.out.println(api.getWeather(user.getLocation()));
    }
}
