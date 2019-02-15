package com.hitesh.mvp_unittesting_sample;

public interface LoginView {

    public String getUserName();
    public String getPassword();

    public void setUsernameError(int msg);
    public void setPasswordError(int msg);

    public void loginSuccess(int msg);
    public void loginFailed(int msg);
}
