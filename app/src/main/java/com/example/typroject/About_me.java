package com.example.typroject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class About_me extends AppCompatActivity {
    ImageView im_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        im_home = findViewById(R.id.tool_home);
        im_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_home = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(to_home);
            }
        });
    }
}