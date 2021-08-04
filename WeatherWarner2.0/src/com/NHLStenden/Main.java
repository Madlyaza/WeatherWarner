package com.NHLStenden;

import com.NHLStenden.Data.User;
import com.NHLStenden.XmlParsing.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException
    {
        GUI gui = new GUI();

        User user = new User("Henk", "Emmen,nl", true);
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();

//        api.getNextTenDays(user.getLocation());
//        XmlMinimumTemperatureTenDays xmlMinimumTemperatureTenDays = new XmlMinimumTemperatureTenDays();
//        xmlMinimumTemperatureTenDays.parseXML(gui);
//
//        XmlMaximumTemperatureTenDays xmlMaximumTemperatureTenDays = new XmlMaximumTemperatureTenDays();
//        xmlMaximumTemperatureTenDays.parseXML(gui);

//        api.getForecastThreeHours(user.getLocation());
//        PrecipitationAlarm precipitationAlarm = new PrecipitationAlarm();
//        precipitationAlarm.start(api, user, sound, gui);
//
//        api.getForecastOneDay(user.getLocation());
//        HeatAlarm heatAlarm = new HeatAlarm();
//        FrostAlarm frostAlarm = new FrostAlarm();
//        frostAlarm.start(api, user, sound, gui);
//        heatAlarm.start(api, user, sound, gui);

        //api.getNextTenDays(user.getLocation());
    }
}
