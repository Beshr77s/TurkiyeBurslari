package com.qashar.turkeyscholiership.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.qashar.turkeyscholiership.Adapters.ListAdapter;
import com.qashar.turkeyscholiership.Fragments.AddFragment;
import com.qashar.turkeyscholiership.Fragments.DialogFragment;
import com.qashar.turkeyscholiership.Fragments.LogFragment;
import com.qashar.turkeyscholiership.Models.Requests;
import com.qashar.turkeyscholiership.R;
import com.qashar.turkeyscholiership.databinding.ActivityReciveBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReciveActivity extends AppCompatActivity {
    private ActivityReciveBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReciveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list();
        Log.d("AAAA",Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID));
        if (Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID).equals("2d485a699118fde8")) {
            Bundle bundle = new Bundle();
            bundle.putString("message", getResources().getString(R.string.message1));
            DialogFragment fragment = new DialogFragment();
            fragment.setArguments(bundle);
            fragment.show(getSupportFragmentManager(), "");
            AddFragment fragment1 = new AddFragment();
            fragment1.show(getSupportFragmentManager(), "");
        }

    }

    private void list() {
        List<Requests> requests = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Models");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                requests.clear();
                requests.add(new Requests("أسم الدولة",null,"بعض التوضيح !!",new Date().getTime()));
                for (DataSnapshot snapshot1 :snapshot.getChildren()) {
                    requests.add(snapshot1.getValue(Requests.class));
                }
                if (requests.size()!=1){
                    binding.txt.setVisibility(View.GONE);
                }
                binding.rv.setAdapter(new ListAdapter(ReciveActivity.this,requests));
                binding.rv.setLayoutManager(new LinearLayoutManager(ReciveActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}