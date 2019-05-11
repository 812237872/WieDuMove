package com.bw.movie.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.NavigationAdapter;
import com.bw.movie.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.navigation_ViewPager)
    android.support.v4.view.ViewPager ViewPager;
    @BindView(R.id.navigation_but_1)
    RadioButton But1;
    @BindView(R.id.navigation_but_2)
    RadioButton But2;
    @BindView(R.id.navigation_but_3)
    RadioButton But3;
    @BindView(R.id.navigation_but_4)
    RadioButton But4;
    @BindView(R.id.navigation_RadioGroup)
    android.widget.RadioGroup RadioGroup;
    @BindView(R.id.navigation_Button)
    android.widget.Button Button;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        list = new ArrayList<Integer>();
        list.add(R.drawable.one);
        list.add(R.drawable.two);
        list.add(R.drawable.three);
        list.add(R.drawable.four);

        NavigationAdapter adapter = new NavigationAdapter(NavigationActivity.this,list);
        ViewPager.setAdapter(adapter);

        ViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (list.size() -1 == i){
                    Button.setVisibility(View.VISIBLE);
                }else {
                    Button.setVisibility(View.GONE);
                }
                switch (i){
                    case 0 :
                        But1.setChecked(true);
                        break;
                    case 1 :
                        But1.setChecked(true);
                        break;
                    case 2 :
                        But1.setChecked(true);
                        break;
                    case 3 :
                        But1.setChecked(true);
                        break;
                }
                RadioGroup.check(RadioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
