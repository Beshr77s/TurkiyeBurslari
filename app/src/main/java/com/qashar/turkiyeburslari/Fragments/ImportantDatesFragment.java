package com.qashar.turkiyeburslari.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.qashar.turkiyeburslari.databinding.AddNewsFragmentBinding;
import com.qashar.turkiyeburslari.databinding.ImportantDatesFragmentBinding;

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
