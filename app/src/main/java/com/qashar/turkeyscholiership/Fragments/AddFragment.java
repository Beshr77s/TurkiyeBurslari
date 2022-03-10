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
import com.qashar.turkeyscholiership.Models.Requests;
import com.qashar.turkeyscholiership.databinding.AddFragmentBinding;
import com.qashar.turkeyscholiership.databinding.AddNewsFragmentBinding;

import java.util.Date;

public class AddFragment extends DialogFragment {
    private AddFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = AddFragmentBinding.inflate(inflater);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = binding.etCountry.getText().toString();
                String note = binding.etNote.getText().toString();
                String url = binding.etUrl.getText().toString();
                Long date = new Date().getTime();
                Requests requests = new Requests(country,url,note,date);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Models");
                reference.push().setValue(requests);
                Snackbar.make(v,"Added SuccessFully !",Snackbar.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();

    }
}
