package com.example.android.recipes.services;

//Retrofit Interface

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface WebService {

    //Trailing slash is needed
    static final String BASE_URL = "http://api.myservice.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
