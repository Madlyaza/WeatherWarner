package com.NHLStenden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
    public void connect()
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "/SQLite/WeatherWarner.db");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
