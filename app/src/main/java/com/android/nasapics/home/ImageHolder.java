package com.android.nasapics.home;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.android.nasapics.ImageDetail.ImageDetailFragment;
import com.android.nasapics.R;

public class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView img;
    private Context context;

    public ImageHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context=context;
        img = itemView.findViewById(R.id.img);
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img:
                openImageDetail(context,(Integer)view.getTag());
                break;
        }
    }

    private void openImageDetail(Context context,int position) {
        FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new ImageDetailFragment(position));
        ft.addToBackStack("Image");
        ft.commit();
    }
}
