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
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        User user = new User("Henk", "Yakutsk,rus");
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();
        api.getForecastThreeHours(user.getLocation());
        XmlPrecipitationAlarm xmlPrecipitationAlarm = new XmlPrecipitationAlarm();
        if (xmlPrecipitationAlarm.parseXML())
        {
            sound.playSound();
        }

        api.getForecastOneDay(user.getLocation());
        XmlHeatAlarm xmlHeatAlarm = new XmlHeatAlarm();
        if (xmlHeatAlarm.checkTemperature(xmlHeatAlarm.parseXML()))
        {
            sound.playSound();
        }

        api.getForecastOneDay(user.getLocation());
        XmlFrostAlarm xmlFrostAlarm = new XmlFrostAlarm();
        if (xmlFrostAlarm.checkTemperature(xmlFrostAlarm.parseXML()))
        {
            sound.playSound();
        }
    }
}
