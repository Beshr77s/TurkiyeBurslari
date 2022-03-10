package com.qashar.turkiyeburslari.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.qashar.turkiyeburslari.R;
import com.qashar.turkiyeburslari.databinding.TurkeyInfoFragmentBinding;

public class TurkeyInfoFragment extends BottomSheetDialogFragment {
    private TurkeyInfoFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TurkeyInfoFragmentBinding.inflate(getLayoutInflater());
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Bundle bundle = getArguments();
        if (bundle.getString("type").equals("turkey")){
            binding.tvTi.setText("ماهي المنحة التركية ؟ ");
            binding.tvTe.setText(getResources().getString(R.string.turkyInfo));
        }else {
            binding.tvTi.setText("ماهي المنحة التركية المشتركة ؟ ");
            binding.tvTe.setText(getResources().getString(R.string.bankInfo));
        }
        return binding.getRoot();
    }
}
