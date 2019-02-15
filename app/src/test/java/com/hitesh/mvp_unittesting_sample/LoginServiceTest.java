package com.hitesh.mvp_unittesting_sample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService service;

    @Before
    public void setUp(){
        service = new LoginService();
    }

    @Test
    public void loginSuccess() {
        assertEquals(service.login("hitesh","pass123"),true);
    }

    @Test
    public void loginFailed() {
        assertEquals(service.login("hitesh","wrongpass"),false);
    }
}