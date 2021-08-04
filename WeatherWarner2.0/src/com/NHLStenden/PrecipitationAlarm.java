package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlPrecipitationAlarm;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PrecipitationAlarm
{
    public void start(ApiCaller api, User user, Sound sound)
    {
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
    }
}
