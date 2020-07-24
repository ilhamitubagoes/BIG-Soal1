package com.ilhambagoest.soal1.data.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.ilhambagoest.soal1.config.Constant;

public class ApiUtils {

    public static RestService getAPIService(){
        return RestServiceFactory.getClient(Constant.BASE_URL).create(RestService.class);
    }

    public static SharedPreferences getDefaultPreferences(Context context) {
        return context.getSharedPreferences(Constant.PREF_NAME, 0);
    }

}
