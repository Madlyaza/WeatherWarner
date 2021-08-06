package com.NHLStenden.XmlParsing;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlPrecipitationAlarmTest
{

    @Test
    void parseXML() throws ParserConfigurationException, IOException, SAXException
    {
        XmlPrecipitationAlarm xmlPrecipitationAlarm = new XmlPrecipitationAlarm();

        // This test is CURRENTLY correct but because an API of the feature cannot be we do not know how to test this correctly for future proofing.
        // Since at the moment there is no rain coming in the next day but this can be run at any moment. We did our research and couldn't figure out how to test it otherwise.
        assertFalse(xmlPrecipitationAlarm.parseXML());
    }
}