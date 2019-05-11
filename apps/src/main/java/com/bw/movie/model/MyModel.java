package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MyModel {

    MyLogin myLogin ;
    MyRegister myRegister ;

    public void mToLogin(String phone , String pwd){
        RetrofitUtil util = RetrofitUtil.getIntsetn();
        Api api = util.getRetrofit(Api.class);
        api.getLogin(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("登录的数据",""+string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void mToRegister(String nickName,String phone,String pwd,String email){
        RetrofitUtil util = RetrofitUtil.getIntsetn();
        Api api = util.getRetrofit(Api.class);

    }

    public void setMyRegister(MyRegister register){
        myRegister = register ;
    }
    public interface MyRegister{
        public void Succeed(Object object);
        public void error(Object object);
    }

    public void setMyLogin(MyLogin login){
        myLogin = login ;
    }
    public interface MyLogin{
        public void Succeed(Object object);
        public void error(Object object);
    }
}
