package com.bw.movie.presenter;

import com.bw.movie.cont.ContractInterface;
import com.bw.movie.model.MyModel;

public class MyPresenter<T> implements ContractInterface.PresenterInterface {
    T tt ;
    MyModel myModel ;

    public MyPresenter(T t){
        tt = t ;
        myModel = new MyModel();
    }

    @Override
    public void pToLogin(String phone, String pwd) {
        myModel.setMyLogin(new MyModel.MyLogin() {
            @Override
            public void Succeed(Object object) {

            }
            @Override
            public void error(Object object) {

            }
        });
        myModel.mToLogin(phone,pwd);
    }

    @Override
    public void pToRegister(String phone, String pwd) {

    }
}
