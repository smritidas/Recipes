package com.example.android.recipes.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.recipes.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit = null;

    @NonNull
    private static Retrofit getRetrofit(String baseUrl) {
        if (retrofit==null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder requestBuilder = chain.request().newBuilder();
                            requestBuilder.header("Content-Type", "application/json;charset=UTF-8");
                            return chain.proceed(requestBuilder.build());
                        }
                    })
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    @NonNull
    public static WebService getWebService() {
        Retrofit retrofit = getRetrofit(Constants.RECIPES_BASE_URL);
        return retrofit.create(WebService.class);
    }
}
