package com.NHLStenden.Data;

import com.NHLStenden.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{

    @org.junit.jupiter.api.Test
    void getName()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        assertEquals("Tester", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void setName()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        Tester.setName("Tester2");
        assertEquals("Tester2", Tester.getName());
    }

    @org.junit.jupiter.api.Test
    void getLocation()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        assertEquals("TestLocation", Tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        Tester.setLocation("TestLocation2");
        assertEquals("TestLocation2", Tester.getLocation());
    }

    @org.junit.jupiter.api.Test
    void setLocation2()
    {
        User Tester = new User("Tester", "TestLocation", 0,"StrongPassword");
        Tester.setLocation("TestLocation2");
        assertNotEquals("TestLocation2", Tester.getLocation());
    }

    @Test
    void getPassword()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        assertEquals("StrongPassword", Tester.getPassword());
    }

    @Test
    void setPassword()
    {
        User Tester = new User("Tester", "TestLocation", 1,"StrongPassword");
        Tester.setPassword("Test1234");
        assertEquals("Test1234", Tester.getPassword());
    }
}