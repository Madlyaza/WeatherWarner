package com.NHLStenden;

public class User
{
    public User(String name, String location)
    {
        this.name = name;
        this.location = location;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    private String location;
}
