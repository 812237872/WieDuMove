package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ContractInterface.LoginInterface {

    @BindView(R.id.phone_id)
    EditText edit_phone;
    @BindView(R.id.pwd_id)
    EditText edit_pwd;
    @BindView(R.id.jzpwd_id)
    CheckBox check;
    @BindView(R.id.quickly_id)
    TextView quicklyId;
    @BindView(R.id.btn_login)
    Button btn_Login;
    @BindView(R.id.wxLogin)
    ImageView imager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        quicklyId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit_phone.getText().toString();
                String s1 = edit_pwd.getText().toString();
                ContractInterface.PresenterInterface presenterInterface = new MyPresenter<>(this);
                presenterInterface.pToLogin(s,s1);
            }
        });

    }

    @Override
    public void showLogin(Object object) {

    }
}
