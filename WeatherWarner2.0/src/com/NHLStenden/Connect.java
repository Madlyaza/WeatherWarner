package com.NHLStenden;

import com.NHLStenden.Data.User;

import java.sql.*;

public class Connect
{
    private Connection conn;
    public static final String TABLE_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";
    public static final String USER_VALUES = "(Name, Password, Admin)";
    public static final String SELECT_PASSWORD_QUERY = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + " =?";
    public static final String INSERT_USER_QUERY = "INSERT INTO " + TABLE_USER + " " + USER_VALUES + " VALUES (=? , =? , = 0)";

    public Connect()
    {
        try
        {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\SQLite\\WeatherWarner.db");
            System.out.println("Connection established");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void addUser(String Name, String Password)
    {
        try
        {
            Statement statement = conn.createStatement();
            statement.execute(INSERT_USER_QUERY);
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getPassword(String Name)
    {
        String password = "";
        // TODO: add prepared satements to this method.
        try
        {
            
            Statement statement = conn.createStatement();
            statement.execute(SELECT_PASSWORD_QUERY);
            System.out.println(SELECT_PASSWORD_QUERY);
            System.out.println(INSERT_USER_QUERY);
            ResultSet results = statement.getResultSet();
                while (results.next())
                {
                    System.out.println(results.getString("Password"));
                    password = results.getString("Password");
                }
                statement.close();
                conn.close();
            System.out.println("Connection closed");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return password;
    }

    public void getLocation()
    {
        // TODO: implement this method.
    }

    public void updateLocation()
    {
        // TODO: implement this method.
    }
}
