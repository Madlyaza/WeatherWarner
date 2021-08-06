package com.NHLStenden;

import com.NHLStenden.XmlParsing.XmlFrostAlarm;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

// The class that checks the coming day for any frost damage to the plants and gives an alarm accordingly
public class FrostAlarm
{
    // Starts the Thread that runs every 24 hours to check for frost damage
    public void start(ApiCaller api, User user, Sound sound, GUI gui)
    {
        Thread frostAlarm = new Thread(() ->
        {
            boolean errorVal = true;
            while (errorVal)
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
                    errorVal = false;
                }
            }
        });
        frostAlarm.start();
    }
}
