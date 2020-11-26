package com.android.nasapics.ImageDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.nasapics.ImageData;
import com.android.nasapics.R;

import java.util.ArrayList;

import utill.AppUtill;

public class ImageDetailAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<ImageData> arrData;

    public ImageDetailAdapter(Context context,int position) {
        this.context = context;
        arrData= AppUtill.getPagerDetailData(position,context);
    }

    @Override
    public int getCount() {
        return arrData.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        String imageUrl = arrData.get(position).getUrl();
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.imagedetailrow, container, false);
        ImageView pagerImage = layout.findViewById(R.id.image_detail);
        AppUtill.showImage(imageUrl, pagerImage);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
