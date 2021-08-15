package com.NHLStenden;

import com.NHLStenden.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{
    private User tester;

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
        tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        System.out.println("Running a test......");
    }

    @org.junit.jupiter.api.Test
    void getName()
    {
        assertEquals("Tester", tester.getName());
    }

    @org.junit.jupiter.api.Test
    void setName()
    {
        tester.setName("Tester2");
        assertEquals("Tester2", tester.getName());
    }

    @org.junit.jupiter.api.Test
    void getLocation()
    {
        assertEquals("TestLocation", tester.getLocation());
        assertEquals("TestLocation", tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation()
    {
        tester.setLocation("TestLocation2");
        assertEquals("TestLocation2", tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation2()
    {
        // must be an admin to change location
        tester.setAdmin(0);
        tester.setLocation("TestLocation2");
        assertNotEquals("TestLocation2", tester.getLocation());
    }

    @Test
    void getPassword()
    {
        assertEquals("StrongPassword", tester.getPassword());
    }

    @Test
    void setPassword()
    {
        tester.setPassword("Test1234");
        assertEquals("Test1234", tester.getPassword());
    }
}