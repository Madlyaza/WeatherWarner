package com.NHLStenden.XmlParsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlFrostAlarmTest
{

    @Test
    void checkTemperature()
    {
        XmlFrostAlarm checker = new XmlFrostAlarm();
        assertTrue(checker.checkTemperature("-0.4") , "Be aware of frost");
    }
}