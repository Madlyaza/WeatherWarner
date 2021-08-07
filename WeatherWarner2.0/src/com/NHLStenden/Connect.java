package com.NHLStenden;

import java.sql.*;

public class Connect
{
    private Connection conn;
    public static final String TABLE_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_ADMIN = "Admin";
    public static final String SELECT_PASSWORD_QUERY = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + " =?";
    public static final String SELECT_USER_QUERY = "SELECT " + COLUMN_NAME + " FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + " =?";
    public static final String SELECT_ADMIN_QUERY = "SELECT " + COLUMN_ADMIN + " FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + " =?";
    public static final String INSERT_USER_QUERY = "INSERT INTO User (Name, Password, Admin) VALUES (?,?,?)";
    public static final String SELECT_LOCATION_QUERY = "SELECT Location FROM Current_Location";

    public Connect()
    {
        try
        {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\SQLite\\WeatherWarner.db");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void start()
    {
        try
        {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\SQLite\\WeatherWarner.db");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean userExists(String Name)
    {
        boolean user = true;
        try
        {
            PreparedStatement getUser = conn.prepareStatement(SELECT_USER_QUERY);
            getUser.setString(1, Name);
            ResultSet results = getUser.executeQuery();
            user = !results.next();
            getUser.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return user;
    }

    public void addUser(String Name, String Password)
    {

        try
        {
            System.out.println(INSERT_USER_QUERY);
            PreparedStatement addUser = conn.prepareStatement(INSERT_USER_QUERY);
            System.out.println(addUser);
            addUser.setString(1,Name);
            addUser.setString(2,Password);
            addUser.setInt(3,0);
            addUser.executeUpdate();
            addUser.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public String getPassword(String Name)
    {
        String password = "";
        try
        {
            PreparedStatement getPassword = conn.prepareStatement(SELECT_PASSWORD_QUERY);
            getPassword.setString(1, Name);
            ResultSet results = getPassword.executeQuery();
                while (results.next())
                {
                    password = results.getString("Password");
                }
                getPassword.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return password;
    }

    public String getLocation()
    {
        String location = "";
        try
        {
            PreparedStatement getLocation = conn.prepareStatement(SELECT_LOCATION_QUERY);
            ResultSet results = getLocation.executeQuery();
                while (results.next())
                {
                    location = results.getString("Location");
                }
                getLocation.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return location;
    }

    public int getAdmin(String Name)
    {
        int admin = 0;
        try
        {
            PreparedStatement getAdmin = conn.prepareStatement(SELECT_ADMIN_QUERY);
            getAdmin.setString(1, Name);
            ResultSet results = getAdmin.executeQuery();
                while (results.next())
                {
                    admin = results.getInt("Admin");
                }
            getAdmin.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return admin;
    }
}
