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

        PrecipitationAlarm precipitationAlarm = new PrecipitationAlarm();
        precipitationAlarm.start(api, user, sound);

        FrostAndHeatAlarm frostAndHeatAlarm = new FrostAndHeatAlarm();
        frostAndHeatAlarm.start(api, user, sound);
    }
}
