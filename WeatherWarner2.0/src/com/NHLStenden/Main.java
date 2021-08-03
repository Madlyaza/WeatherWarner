package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlThreeHoursForecast;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        User user = new User("Henk", "Emmen");
        ApiCaller api = new ApiCaller();
        api.getForecastThreeHours(user.getLocation());
        XmlThreeHoursForecast xml = new XmlThreeHoursForecast();
        try
        {
            xml.parseXML();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (SAXException e)
        {
            e.printStackTrace();
        }

    }
}
