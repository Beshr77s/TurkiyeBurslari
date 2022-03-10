package com.qashar.turkiyeburslari.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.qashar.turkiyeburslari.databinding.ActivityReaderBinding;

public class ReaderActivity extends AppCompatActivity {
    private ActivityReaderBinding binding;
    private Integer textSize = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReaderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvText.setTextSize(textSize);
        try {
            String title = getIntent().getStringExtra("title");
            String text = getIntent().getStringExtra("text");
            binding.tvTitle.setText(title);
            binding.tvText.setText(text);
        }catch (Exception e){}
        binding.btnNormalTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvText.setTextSize(20);
            }
        });
        binding.btnAddTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize++;
                binding.tvText.setTextSize(textSize);
            }
        });
        binding.btnTakeTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize--;
                binding.tvText.setTextSize(textSize);
            }
        });
    }
}