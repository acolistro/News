package com.example.news.service;

import android.util.Log;

import com.example.news.model.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceHelper {
    public static Retrofit retrofit=null;
    //okhttp


    public static HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override public void log(String message) {
            Log.i("Http_Articles",""+message );
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY);


    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggerInterceptor)
            .build();



    public static IApiHelper getRestAPIHelper(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit.create(IApiHelper.class);
    }
}
