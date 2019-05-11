package com.bw.movie.util;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil util ;
    OkHttpClient okHttpClient ;
    private final Retrofit retrofit;

    private RetrofitUtil(){
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                return proceed;
            }
        }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(UriCl.getBase)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitUtil getIntsetn(){
        if (util == null){
            util = new RetrofitUtil();
        }
        return util ;
    }

    public <T> T getRetrofit(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
