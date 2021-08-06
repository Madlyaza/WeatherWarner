package com.NHLStenden;

public class User
{
    private String name;
    private String location;
    private int isAdmin; // SQLite doesn't support booleans so an int is used instead of a boolean, 1 means that the user is an admin, 0 means the user isn't an admin.
    private String password;

    /**
     * Constructor for the user class
     *
     * @param name, location, isAdmin, password
     * @return User object
     */
    public User(String name, String location, int isAdmin, String password)
    {
        this.name = name;
        this.location = location;
        this.isAdmin = isAdmin;
        this.password = password;
    }


    /**
     * @Return the name of the user as a String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the username
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * @return isAdmin, 0 for a normal user and 1 for an administrator.
     */
    public int isAdmin()
    {
        return isAdmin;
    }

    /**
     * @param admin
     */
    public void setAdmin(int admin)
    {
        isAdmin = admin;
    }

    /**
     * @param location, if user is an administrator.
     */
    public void setLocation(String location)
    {
        if (isAdmin == 1)
        {
            this.location = location;
            System.out.println("Location has been updated to: " + location);
        } else
        {
            System.out.println("Unable to comply, you are not authorised to change the location.");
        }
    }

    /**
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

}
