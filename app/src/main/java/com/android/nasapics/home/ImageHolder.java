package com.android.nasapics.home;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.nasapics.R;

public class ImageHolder extends RecyclerView.ViewHolder {
    public ImageView img;
    public ImageHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
    }
}
