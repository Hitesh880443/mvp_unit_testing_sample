package com.hitesh.mvp_unittesting_sample;

public class LoginPresenter {

    private LoginView loginView;
    private LoginService loginService;

    public LoginPresenter(LoginView loginView, LoginService loginService) {
        this.loginView = loginView;
        this.loginService = loginService;
    }

    public void doLogin() {

        String username = loginView.getUserName();
        String password = loginView.getPassword();

        if (username.isEmpty()) {
            loginView.setUsernameError(R.string.username);
            return;
        }

        if (password.isEmpty()) {
            loginView.setPasswordError(R.string.password);
            return;
        }

        if (loginService.login(username, password)) {
            loginView.loginSuccess(R.string.login_success);
        } else
            loginView.loginFailed(R.string.login_failed);
    }
}
