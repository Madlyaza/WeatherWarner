package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlPrecipitationAlarm;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PrecipitationAlarm
{
    public void start(ApiCaller api, User user, Sound sound, GUI gui)
    {
        Thread precipitationAlarm = new Thread(() ->
        {
            boolean errorVal = true;
            while (errorVal)
            {
                try
                {
                    api.getForecastThreeHours(user.getLocation());
                    XmlPrecipitationAlarm xmlPrecipitationAlarm = new XmlPrecipitationAlarm();
                    if (xmlPrecipitationAlarm.parseXML())
                    {
                        sound.playSound();
                        gui.setFrostWarningText("Rain damage is expected for tomorrow!");
                    }
                    else
                    {
                        gui.setPrecipitationWarningText("No rain damage is expected for tomorrow.");
                    }

                    Thread.sleep(1000 * 60 * 60 * 3);
                } catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The precipitation timer has stopped. Please restart the application to make sure the timer is working again.");
                    ie.printStackTrace();
                    errorVal = false;
                }
            }
        });
        precipitationAlarm.start();
    }
}
