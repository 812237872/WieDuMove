package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class NavigationAdapter extends PagerAdapter {
    private final Context context;
    private final List<Integer> list;

    public NavigationAdapter(Context context, List<Integer> list) {
        this.context = context ;
        this.list = list ;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        //设置图片
        imageView.setImageResource(list.get(position));
        //设置图片的伸缩尺寸
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //添加道容器中
        container.addView(imageView);
        return imageView ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //需要删除
        container.removeView((View) object);
    }
}
