package com.NHLStenden;

import com.NHLStenden.Data.User;
import org.xml.sax.SAXException;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        User user = new User("Henk", "Emmen");
        ApiCaller api = new ApiCaller();
        api.getForecastThreeHours(user.getLocation());
        XmlParser xml = new XmlParser();
        try
        {
            xml.parseXML();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (SAXException e)
        {
            e.printStackTrace();
        }

    }
}
