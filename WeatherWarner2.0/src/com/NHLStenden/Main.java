package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlOneDayForecast;
import com.NHLStenden.XmlParsing.XmlThreeHoursForecast;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        User user = new User("Henk", "columbia,us");
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();
        //api.getForecastThreeHours(user.getLocation());
        api.getForecastOneDay(user.getLocation());
        XmlOneDayForecast xml = new XmlOneDayForecast();
        try
        {
            xml.checkTemperature(xml.parseXML());

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
