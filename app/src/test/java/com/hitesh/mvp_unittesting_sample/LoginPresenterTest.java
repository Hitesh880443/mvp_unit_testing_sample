package com.hitesh.mvp_unittesting_sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {


    @Mock
    LoginService service;
    @Mock
    LoginView view;
    LoginPresenter presenter;


    @Before
    public void setUp() {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void showErrorForEmptyUsername() {
        when(view.getUserName()).thenReturn("");
        presenter.doLogin();
        verify(view).setUsernameError(R.string.username);
    }


    @Test
    public void showErrorForEmptyPassword() {
        when(view.getUserName()).thenReturn("hitesh");
        when(view.getPassword()).thenReturn("");
        presenter.doLogin();
        verify(view).setPasswordError(R.string.password);
    }

    @Test
    public void showErrorLoginFailed(){
        when(view.getUserName()).thenReturn("hitesh");
        when(view.getPassword()).thenReturn("wrongpassword");
        when(service.login("hitesh","wrongpassword")).thenReturn(false);
        presenter.doLogin();
        verify(view).loginFailed(R.string.login_failed);
    }

    @Test
    public void showLoginSuccess(){
        when(view.getUserName()).thenReturn("hitesh");
        when(view.getPassword()).thenReturn("pass123");
        when(service.login("hitesh","pass123")).thenReturn(true);
        presenter.doLogin();
        verify(view).loginSuccess(R.string.login_success);
    }
}