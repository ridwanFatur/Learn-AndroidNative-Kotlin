package com.ridwanproduction.learnandroidkotlin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ridwanproduction.learnandroidkotlin.R;

import java.util.List;

public class ArAdapter extends PagerAdapter {
    List<Integer> images;
    Context context;

    public ArAdapter(List<Integer> images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position));

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
