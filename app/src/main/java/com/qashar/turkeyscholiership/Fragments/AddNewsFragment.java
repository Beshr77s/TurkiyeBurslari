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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.qashar.turkeyscholiership.Models.News;
import com.qashar.turkeyscholiership.databinding.AddNewsFragmentBinding;

import java.util.Date;

public class AddNewsFragment extends DialogFragment {
    private AddNewsFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = AddNewsFragmentBinding.inflate(inflater);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.btnAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.etText.getText().toString();
                Long date = new Date().getTime();
                News news = new News(text,date);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference();
                reference.child("lastNews").setValue(text);
                reference.child("lastDate").setValue(date);


                Snackbar.make(v,"Added SuccessFully !",Snackbar.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();

    }
}
