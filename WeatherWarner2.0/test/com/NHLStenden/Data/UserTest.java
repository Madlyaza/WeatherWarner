package com.NHLStenden.Data;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{

    @org.junit.jupiter.api.Test
    void getName()
    {
        User Tester = new User("Tester", "TestLocation", true);
        assertEquals("Tester", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void setName()
    {
        User Tester = new User("Tester", "TestLocation", true);
        Tester.setName("Tester2");
        assertEquals("Tester2", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void getLocation()
    {
        User Tester = new User("Tester", "TestLocation", true);
        assertEquals("TestLocation", Tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation()
    {
        User Tester = new User("Tester", "TestLocation", true);
        Tester.setLocation("TestLocation2");
        assertEquals("TestLocation2", Tester.getLocation());
    }
}