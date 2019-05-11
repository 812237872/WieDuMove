package com.bw.movie.acitivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bw.movie.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    int i = 5 ;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (i > 0) {
                i-- ;
                handler.sendEmptyMessageDelayed(0,1000);
            }
            else {
                Intent intent = new Intent(MainActivity.this,NavigationActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.Start_imageView);

        handler.sendEmptyMessageDelayed(0,1000);


    }
}
