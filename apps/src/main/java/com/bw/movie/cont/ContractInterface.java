package com.bw.movie.cont;

public interface ContractInterface {

    //登录页面
    public interface LoginInterface{
        public void showLogin(Object object);
    }
    //注册页面
    public interface RegisterInterface{
        public void showRegister(Object object);
    }

    //P层接口
    public interface PresenterInterface{
        public void pToLogin(String phone , String pwd);
        public void pToRegister(String phone , String pwd);
    }

}
