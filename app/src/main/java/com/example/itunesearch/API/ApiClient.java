package com.example.itunesearch.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private  static  final String BASE_URL="https://itunes.apple.com/";
    private static Retrofit retrofit;
    private  static ApiClient apiClient;


    private ApiClient(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public  static synchronized ApiClient getInstance(){
        if(apiClient==null){

            apiClient=new ApiClient();

        }
        return  apiClient;
    }
    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }


}
