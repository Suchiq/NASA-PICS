package com.android.nasapics.home;

import android.content.Context;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.nasapics.ImageData;
import com.android.nasapics.interfaces.IGalleryFragment;

import java.util.ArrayList;

import utill.AppUtill;

public class HomePresenter {
    IGalleryFragment listner;

    public static HomePresenter getInstance(IGalleryFragment listner) {
        HomePresenter instance = new HomePresenter();
        instance.listner = listner;
        return instance;
    }

    public void populateView(Context context) {
        ArrayList<ImageData> arrData = AppUtill.getData(context);

        GalleryAdapter adapter = new GalleryAdapter(arrData);
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2);
        listner.getBinding().recyclerView.setLayoutManager(manager);
        listner.getBinding().recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        listner.getBinding().recyclerView.setAdapter(adapter);
    }
}
