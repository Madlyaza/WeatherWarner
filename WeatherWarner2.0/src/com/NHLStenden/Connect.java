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
    public static final String SELECT_USER_QUERY = "SELECT " + COLUMN_NAME + " FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + " =?";
    public static final String INSERT_USER_QUERY = "INSERT INTO " + TABLE_USER + " " + USER_VALUES + " VALUES (=? , =? , = 0)";

    public Connect()
    {
        try
        {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "src\\SQLite\\WeatherWarner.db");
            System.out.println("Connection established");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean addUser(String Name, String Password)
    {
        boolean user = true;
        try
        {
            PreparedStatement getUser = conn.prepareStatement(SELECT_USER_QUERY);
            getUser.setString(1, Name);
            ResultSet results = getUser.executeQuery();
            if (!results.next())
            {
                try
                {
                    PreparedStatement addUser = conn.prepareStatement(INSERT_USER_QUERY);
                    System.out.println(INSERT_USER_QUERY);
                    System.out.println(addUser);
                    addUser.setString(1,Name);
                    addUser.setString(2,Password);
                    getUser.executeUpdate();
                    user = true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                user = false;
            }
            getUser.close();
            conn.close();
            System.out.println("Connection closed");

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return user;
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
                conn.close();
            System.out.println("Connection closed");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return password;
    }
}
