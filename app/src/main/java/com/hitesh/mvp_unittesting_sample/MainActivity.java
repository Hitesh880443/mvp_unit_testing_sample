package com.hitesh.mvp_unittesting_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {


    private EditText mUsername, mPassword;
    private Button mLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        mLoginPresenter = new LoginPresenter(this, new LoginService());
    }

    private void setView() {
        mUsername = findViewById(R.id.et_username);
        mPassword = findViewById(R.id.et_password);
        mLogin = findViewById(R.id.btn_login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.doLogin();
            }
        });
    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void setUsernameError(int msg) {
        mUsername.setError(getString(msg));
    }

    @Override
    public void setPasswordError(int msg) {
        mPassword.setError(getString(msg));
    }

    @Override
    public void loginSuccess(int msg) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(int msg) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_SHORT).show();
    }
}
