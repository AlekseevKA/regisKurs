package com.example.regis;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface regService {



    @POST("user")
        // Call<RegModel> createreg(@Body RegModel regModel);
    Call<RegModel>PostDataIntoServer(@Body RegModel regModel);

  /*/  @FormUrlEncoded
    @POST("user")
    Call<RegModel> createreg(@Field("name") String name, @Field("email") String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("user")
    Call<RegModel> createreg(@FieldMap Map<String, String> fields);
    /*/



}
