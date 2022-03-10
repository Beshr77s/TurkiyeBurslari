package com.qashar.turkeyscholiership.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;
import com.qashar.turkeyscholiership.Models.News;
import com.qashar.turkeyscholiership.databinding.AddNewsFragmentBinding;
import com.qashar.turkeyscholiership.databinding.ImportantDatesFragmentBinding;

import java.util.Date;

public class ImportantDatesFragment extends DialogFragment {
    private ImportantDatesFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = ImportantDatesFragmentBinding.inflate(inflater);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().setCancelable(false);
        binding.icClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return binding.getRoot();

    }
}
