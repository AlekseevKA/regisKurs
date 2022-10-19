package com.example.regis;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class regRepository {
   /*/ private static regRepository instance;

    private regService regService;

    public static regRepository getInstance() {
        if (instance == null) {
            instance = new regRepository();
        }
        return instance;
    }

    public regRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://smarthome.madskill.ru/user")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        regService = retrofit.create(regService.class);
    }

    public regService getRegService() {
        return regService;
    }
/*/
}
