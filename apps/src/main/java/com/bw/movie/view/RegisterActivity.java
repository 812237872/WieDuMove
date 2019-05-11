package com.bw.movie.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_name)
    EditText edit_Name;
    @BindView(R.id.register_sex)
    EditText edit_Sex;
    @BindView(R.id.register_data)
    EditText edit_Data;
    @BindView(R.id.register_phone)
    EditText edit_Phone;
    @BindView(R.id.register_emil)
    EditText edit_Emil;
    @BindView(R.id.register_pwd)
    EditText edit_Pwd;
    @BindView(R.id.text_login)
    TextView textLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_Name.getText().toString();
                String sex = edit_Sex.getText().toString();
                String data = edit_Data.getText().toString();
                String phone = edit_Phone.getText().toString();
                String emil = edit_Emil.getText().toString();
                String pwd = edit_Pwd.getText().toString();

                ContractInterface.PresenterInterface presenterInterface = new MyPresenter<>(this);

            }
        });



    }
}
