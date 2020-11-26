package com.android.nasapics.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android.nasapics.R;
import com.android.nasapics.databinding.GalleryLayoutBinding;
import com.android.nasapics.interfaces.IGalleryFragment;

public class GalleryFragment extends Fragment implements IGalleryFragment {
    private GalleryLayoutBinding galleryBinding;
    private HomePresenter homePresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePresenter = HomePresenter.getInstance(this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        galleryBinding = DataBindingUtil.inflate(inflater, R.layout.gallery_layout, container, false);
        homePresenter.populateView(getContext());
        return galleryBinding.getRoot();
    }

    @Override
    public GalleryLayoutBinding getBinding() {
        return galleryBinding;
    }
}
