package com.qashar.turkiyeburslari.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.qashar.turkiyeburslari.databinding.AddNewsFragmentBinding;
import com.qashar.turkiyeburslari.databinding.DialogFragmentBinding;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    private DialogFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DialogFragmentBinding.inflate(inflater);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Bundle bundle = getArguments();
        binding.tvMessage.setText(bundle.getString("message"));

        return binding.getRoot();

    }
}
