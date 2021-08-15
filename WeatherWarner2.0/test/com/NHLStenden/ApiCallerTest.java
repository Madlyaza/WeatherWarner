package com.NHLStenden;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class ApiCallerTest
{
    @BeforeEach
    void setUp() throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "XmlParsing.xml");
        writer.print("");
        writer.close();
    }

    @Test
    void getForecastThreeHours()
    {
        ApiCaller api = new ApiCaller();
        api.getForecastThreeHours("Hoogeveen");

        File xml = new File("XmlParsing.xml");

        assertNotEquals(0, xml.length());
    }

    @Test
    void getForecastOneDay()
    {
        ApiCaller api = new ApiCaller();
        api.getForecastOneDay("Hoogeveen");

        File xml = new File("XmlParsing.xml");

        assertNotEquals(0, xml.length());
    }

    @Test
    void getNextTenDays()
    {
        ApiCaller api = new ApiCaller();
        api.getNextTenDays("Hoogeveen");

        File xml = new File("XmlParsing.xml");

        assertNotEquals(0, xml.length());
    }
}