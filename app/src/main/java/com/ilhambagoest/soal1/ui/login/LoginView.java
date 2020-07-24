package com.ilhambagoest.soal1.ui.login;


import com.ilhambagoest.soal1.data.entity.DataUser;

interface LoginView  {
    void showLoginSuccess(DataUser dataUser);
    void showLoginFailed(Throwable throwable);
}
