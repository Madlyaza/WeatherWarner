package com.NHLStenden;

import static org.junit.jupiter.api.Assertions.*;

class FrostAlarmTest
{
    @org.junit.jupiter.api.Test
    public frostAlarmTest()
    {
        ApiCaller apiCaller = new ApiCaller();
        User user = new User("Tester","Hoogeveen", 0, "StrongPassword");
        GUI gui = new GUI();
        Sound sound = new Sound();
        FrostAlarm frostAlarm = new FrostAlarm(apiCaller, user, sound, gui);
        frostAlarm.ge

                // TODO: Finish this unit test
    }

}