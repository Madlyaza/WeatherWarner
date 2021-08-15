package com.NHLStenden;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest
{
    private Connect connection;

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
       connection = new Connect();
    }
}