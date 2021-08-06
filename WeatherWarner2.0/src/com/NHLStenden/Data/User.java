package com.NHLStenden.Data;

public class User
{
    private String name;
    private String location;
    private int isAdmin; // SQLite doesn't support booleans so an int is used instead of a boolean, 1 means that the user is an admin, 0 means the user isn't an admin.
    private String password;

    public User(String name, String location, int isAdmin, String password)
    {
        this.name = name;
        this.location = location;
        this.isAdmin = isAdmin;
        this.password = password;
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

    public int isAdmin()
    {
        return isAdmin;
    }

    public void setAdmin(int admin)
    {
        isAdmin = admin;
    }

    public void setLocation(String location)
    {
        if (isAdmin == 1)
        {
            this.location = location;
            System.out.println("Location has been updated to: " + location);
        }
        else
        {
            System.out.println("Unable to comply, you are not authorised to change the location.");
        }
    }

    public String getPassword()
    {
            return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
