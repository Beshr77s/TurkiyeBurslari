package com.qashar.turkiyeburslari.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.qashar.turkiyeburslari.R;
import com.qashar.turkiyeburslari.databinding.AddNewsFragmentBinding;
import com.qashar.turkiyeburslari.databinding.LogFragmentBinding;

public class LogFragment extends DialogFragment {
    private LogFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = LogFragmentBinding.inflate(inflater);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.link1)));
                startActivity(intent);
            }
        });  binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.link2)));
                startActivity(intent);
            }
        });  binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.link3)));
                startActivity(intent);
            }
        });
        return binding.getRoot();

    }
}
