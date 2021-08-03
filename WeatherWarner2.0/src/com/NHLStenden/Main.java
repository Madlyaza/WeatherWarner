package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlOneDayForecast;
import com.NHLStenden.XmlParsing.XmlThreeHoursForecast;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        User user = new User("Henk", "columbia,us");
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();
        api.getForecastThreeHours(user.getLocation());
        XmlThreeHoursForecast xmlThreeHoursForecast = new XmlThreeHoursForecast();
        if (xmlThreeHoursForecast.parseXML())
        {
            sound.playSound();
        }
        api.getForecastOneDay(user.getLocation());
        XmlOneDayForecast xml = new XmlOneDayForecast();
        if (xml.checkTemperature(xml.parseXML()))
        {
            sound.playSound();
        }
    }
}
