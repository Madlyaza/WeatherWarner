package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlFrostAlarm;
import com.NHLStenden.XmlParsing.XmlHeatAlarm;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FrostAndHeatAlarm
{
    public void start(ApiCaller api, User user, Sound sound)
    {
        Thread frostAndHeatAlarm = new Thread(() ->
        {
            while (true)
            {
                try
                {
                    System.out.println("Frost and heat alarm started.");
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
                } catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The heat and cold timer has stopped working. Please restart the application to make sure the time is working again.");
                    ie.printStackTrace();
                }
            }
        });
        frostAndHeatAlarm.start();
    }
}
