package com.ilhambagoest.soal1.ui.home;


import java.util.List;

interface HomeView {
    void showImage(List<String> imageList);
    void showError(Throwable throwable);
}
