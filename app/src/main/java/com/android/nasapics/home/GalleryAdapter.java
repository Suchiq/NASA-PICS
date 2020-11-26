package com.android.nasapics.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.nasapics.ImageData;
import com.android.nasapics.R;

import java.util.ArrayList;

import utill.AppUtill;

public class GalleryAdapter extends RecyclerView.Adapter<ImageHolder> {
    private ArrayList<ImageData> arrData;
    public GalleryAdapter(ArrayList<ImageData> arrData) {
        this.arrData=arrData;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_row, parent, false);
       return new ImageHolder(itemView,parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        AppUtill.showImage(arrData.get(position).getUrl(),holder.img);
    }



    @Override
    public int getItemCount() {
        return arrData.size();
    }
}
