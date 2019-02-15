package com.hitesh.mvp_unittesting_sample;

public class LoginService {

    public boolean login(String username, String password) {
        if (username.equals("hitesh") && password.equals("pass123"))
            return true;
        else
            return false;
    }
}
