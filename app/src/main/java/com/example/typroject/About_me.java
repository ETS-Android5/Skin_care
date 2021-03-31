package com.example.typroject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class About_me extends AppCompatActivity {
    ImageView im_home;
    LinearLayout email;
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

//        email = findViewById(R.id.email);
//        email.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent email = new Intent(Intent.CATEGORY_APP_EMAIL);
//                startActivity(email);
//
//            }
//        });
    }
}