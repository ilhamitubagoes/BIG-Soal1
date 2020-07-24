package com.ilhambagoest.soal1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ilhambagoest.soal1.MainActivity;
import com.ilhambagoest.soal1.R;
import com.ilhambagoest.soal1.data.SessionManager;
import com.ilhambagoest.soal1.data.api.ApiUtils;
import com.ilhambagoest.soal1.data.entity.DataAuth;
import com.ilhambagoest.soal1.data.entity.DataUser;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText etUsername, etPassword;
    Button btnLogin;
    LoginPresenter presenter;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        presenter = new LoginPresenter(this);
        session = new SessionManager(ApiUtils.getDefaultPreferences(this));

        checkIsLogin();

        initEvent();
    }

    private void checkIsLogin() {
        if (session.isLogin()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Log.i(LoginActivity.class.getName(), "User Belum Login");
        }
    }

    private void initEvent() {
        btnLogin.setOnClickListener(v -> {
            if (isValid()){
                presenter.login(new DataAuth(etUsername.getText().toString(), etPassword.getText().toString()));
            }
        });
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(etUsername.getText().toString())){
            Toast.makeText(this, "Username Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())){
            Toast.makeText(this, "Password Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void showLoginSuccess(DataUser dataUser) {
        session.setIsLogin();
        session.setUserId(dataUser.getId());
        session.setUserName(dataUser.getName());
        session.setUserPosition(dataUser.getPosition());
        session.setUserBirthDate(dataUser.getBirthDate());
        session.setUserUrlPhoto(dataUser.getUrlPhoto());

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void showLoginFailed(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}