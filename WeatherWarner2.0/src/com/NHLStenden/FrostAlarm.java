package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.XmlFrostAlarm;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FrostAlarm
{
    public void start(ApiCaller api, User user, Sound sound, GUI gui)
    {
        Thread frostAlarm = new Thread(() ->
        {
            while (true)
            {
                try
                {
                    api.getForecastOneDay(user.getLocation());
                    XmlFrostAlarm xmlFrostAlarm = new XmlFrostAlarm();
                    if (xmlFrostAlarm.checkTemperature(xmlFrostAlarm.parseXML()))
                    {
                        sound.playSound();
                        gui.setFrostWarningText("Frost damage is expected for tomorrow!");
                    }
                    else
                    {
                        gui.setFrostWarningText("No frost damage is expected for tomorrow.");
                    }

                    Thread.sleep(1000 * 60 * 60 * 24);
                } catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The Frost timer has stopped working.");
                    ie.printStackTrace();
                }
            }
        });
        frostAlarm.start();
    }
}
