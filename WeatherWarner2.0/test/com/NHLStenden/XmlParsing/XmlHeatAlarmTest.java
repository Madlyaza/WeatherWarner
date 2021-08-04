package com.NHLStenden.XmlParsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlHeatAlarmTest
{

    @Test
    void checkTemperature()
    {
        XmlHeatAlarm checker = new XmlHeatAlarm();
        assertTrue(checker.checkTemperature("25.1") , "Be aware of heat");
    }
}