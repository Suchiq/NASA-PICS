package com.android.nasapics.ImageDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android.nasapics.R;
import com.android.nasapics.databinding.ImageDetailLayoutBinding;

public class ImageDetailFragment extends Fragment {
    private ImageDetailLayoutBinding binding;
    private int position;


    public ImageDetailFragment(int position) {
        this.position=position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.image_detail_layout, container, false);
        binding.viewPager.setAdapter(new ImageDetailAdapter(getContext(),position));
        return binding.getRoot();
    }
}
