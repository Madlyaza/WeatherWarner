package com.NHLStenden;

import com.NHLStenden.XmlParsing.XmlHeatAlarm;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class HeatAlarm
{
    public void start(ApiCaller api, User user, Sound sound, GUI gui)
    {
        Thread heatAlarm = new Thread(() ->
        {
            boolean errorVal = true;
            while (errorVal)
            {
                try
                {
                    api.getForecastOneDay(user.getLocation());
                    XmlHeatAlarm xmlHeatAlarm = new XmlHeatAlarm();
                    if (xmlHeatAlarm.checkTemperature(xmlHeatAlarm.parseXML()))
                    {
                        sound.playSound();
                        gui.setHeatWarningText("Heat damage is expected for tomorrow!");
                    }
                    else
                    {
                        gui.setHeatWarningText("No heat damage is expected for tomorrow.");
                    }

                    Thread.sleep(1000 * 60 * 60 * 24);
                } catch (InterruptedException | ParserConfigurationException | IOException | SAXException ie)
                {
                    System.out.println("The Heat timer has stopped working.");
                    ie.printStackTrace();
                    errorVal = false;
                }
            }
        });
        heatAlarm.start();
    }
}
