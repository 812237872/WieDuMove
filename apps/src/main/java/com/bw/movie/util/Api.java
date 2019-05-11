package com.bw.movie.util;

import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @POST("login")
    public Observable<ResponseBody> getLogin(@Query("phone")String phone , @Query("pwd")String pwd);

}
