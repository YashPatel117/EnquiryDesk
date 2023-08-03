package com.example.enquirydesk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBaseUrl {

    String url = "https://brahminnerbrain.com/online_tuition_class/public/index.php/api/";
    public static RetrofitBaseUrl instance ;
    public API apiinterface ;
    RetrofitBaseUrl(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiinterface = retrofit.create(API.class);
    }

    public static RetrofitBaseUrl getInstance()
    {
        if(instance==null)
        {
            instance = new RetrofitBaseUrl();
        }
        return instance;
    }
}
