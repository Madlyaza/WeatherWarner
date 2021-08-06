package com.NHLStenden;

import com.NHLStenden.XmlParsing.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException
    {
        User user = new User("Henk", "hoogeveen", 1, "moi123");
        //Connect conn = new Connect();
        //conn.addUser("Yen", "yenyen");
        //LoginPage loginPage = new LoginPage();
        GUI gui = new GUI();

        //User user = new User("Henk", "Hoogeveen,nl", true);
        Sound sound = new Sound();
        ApiCaller api = new ApiCaller();

        XmlTemperatureHistory xmlTemperatureHistory = new XmlTemperatureHistory();
        xmlTemperatureHistory.parseXML(gui, user.getLocation());

        XmlPrecipitationHistory xmlPrecipitationHistory = new XmlPrecipitationHistory();
        xmlPrecipitationHistory.parseXML(gui, user.getLocation());

        api.getNextTenDays(user.getLocation());
        XmlMinimumTemperatureTenDays xmlMinimumTemperatureTenDays = new XmlMinimumTemperatureTenDays();
        xmlMinimumTemperatureTenDays.parseXML(gui);

        XmlMaximumTemperatureTenDays xmlMaximumTemperatureTenDays = new XmlMaximumTemperatureTenDays();
        xmlMaximumTemperatureTenDays.parseXML(gui);

        XmlWindDirectionTenDays xmlWindDirectionTenDays = new XmlWindDirectionTenDays();
        xmlWindDirectionTenDays.parseXML(gui);

        XmlWindspeedTenDays xmlWindspeedTenDays = new XmlWindspeedTenDays();
        xmlWindspeedTenDays.parseXML(gui);

        PrecipitationAlarm precipitationAlarm = new PrecipitationAlarm();
        precipitationAlarm.start(api, user, sound, gui);

        HeatAlarm heatAlarm = new HeatAlarm();
        FrostAlarm frostAlarm = new FrostAlarm();
        frostAlarm.start(api, user, sound, gui);
        heatAlarm.start(api, user, sound, gui);
    }
}
