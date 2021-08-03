package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlFrostAlarm;
import com.NHLStenden.XmlParsing.XmlHeatAlarm;
import com.NHLStenden.XmlParsing.XmlPrecipitationAlarm;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        User user = new User("Henk", "Emmen,nl");
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();

        Thread precipitationAlarm = new Thread(() ->
        {
            while(true)
            {
                try
                {
                    api.getForecastThreeHours(user.getLocation());
                    XmlPrecipitationAlarm xmlPrecipitationAlarm = new XmlPrecipitationAlarm();
                    if (xmlPrecipitationAlarm.parseXML())
                    {
                        sound.playSound();
                    }
                    Thread.sleep(1000 * 60 * 60 * 3);
                }
                catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The precipitation timer has stopped. Please restart the application to make sure the timer is working again.");
                    ie.printStackTrace();
                }
            }
        });
        precipitationAlarm.start();

        Thread frostAndHeatAlarm = new Thread(() ->
        {
            while(true)
            {
                try
                {
                    api.getForecastOneDay(user.getLocation());
                    XmlHeatAlarm xmlHeatAlarm = new XmlHeatAlarm();
                    if (xmlHeatAlarm.checkTemperature(xmlHeatAlarm.parseXML()))
                    {
                        sound.playSound();
                    }

                    XmlFrostAlarm xmlFrostAlarm = new XmlFrostAlarm();
                    if (xmlFrostAlarm.checkTemperature(xmlFrostAlarm.parseXML()))
                    {
                        sound.playSound();
                    }

                    Thread.sleep(1000 * 60 * 60 * 24);
                }
                catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The heat and cold timer has stopped working. Please restart the application to make sure the time is working again.");
                    ie.printStackTrace();
                }
            }
        });
        frostAndHeatAlarm.start();
    }
}
