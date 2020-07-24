package com.ilhambagoest.soal1.data.api;

import com.ilhambagoest.soal1.data.entity.DataAuth;
import com.ilhambagoest.soal1.data.entity.DataUser;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestService {

    @POST("/LOGIN")
    Call<DataUser> loginUser(@Body DataAuth dataAuth);

    @GET("/image")
    Call<List<String>> getImage();

    @GET("/menu")
    Call<HashMap<String, String>> getMenu();

}