package com.NHLStenden.Data;

public class User
{
    private String name;
    private String location;
    private boolean isAdmin;

    public User(String name, String location, boolean isAdmin)
    {
        this.name = name;
        this.location = location;
        this.isAdmin = isAdmin;
    }


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
        if (isAdmin)
        {
            this.location = location;
            System.out.println("Location has been updated to: " + location);
        }
        else
        {
            System.out.println("Unable to comply, you are not authorised to change the location.");
        }
    }

}
