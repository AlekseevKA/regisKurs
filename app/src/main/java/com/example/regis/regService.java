package com.example.regis;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface regService {
    @POST("name")
    Call<reg> createreg(@Body reg reg);

    @FormUrlEncoded
    @POST("name")
    Call<reg> createreg(@Field("name") String name, @Field("email") String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("name")
    Call<reg> createreg(@FieldMap Map<String, String> fields);
}
