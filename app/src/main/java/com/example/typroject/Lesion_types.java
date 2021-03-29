package com.example.typroject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

public class Lesion_types extends AppCompatActivity {
    ImageView imageView ;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesion_types);
        imageView = findViewById(R.id.Melanocytic_i);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.melanocytic));
    }
}