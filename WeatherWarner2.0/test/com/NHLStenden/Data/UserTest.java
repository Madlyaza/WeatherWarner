package com.NHLStenden.Data;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{

    @org.junit.jupiter.api.Test
    void getName()
    {
        User Tester = new User("Tester", "TestLocation", true,"StrongPassword");
        assertEquals("Tester", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void setName()
    {
        User Tester = new User("Tester", "TestLocation", true,"StrongPassword");
        Tester.setName("Tester2");
        assertEquals("Tester2", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void getLocation()
    {
        User Tester = new User("Tester", "TestLocation", true,"StrongPassword");
        assertEquals("TestLocation", Tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation()
    {
        User Tester = new User("Tester", "TestLocation", true,"StrongPassword");
        Tester.setLocation("TestLocation2");
        assertEquals("TestLocation2", Tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation2()
    {
        User Tester = new User("Tester", "TestLocation", false,"StrongPassword");
        Tester.setLocation("TestLocation2");
        assertNotEquals("TestLocation2", Tester.getLocation());
    }
}