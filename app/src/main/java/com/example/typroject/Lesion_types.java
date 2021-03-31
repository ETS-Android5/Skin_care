package com.example.typroject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Lesion_types extends AppCompatActivity {
    ImageView im_home;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesion_types);
        im_home = findViewById(R.id.tool_home);
        im_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_home = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(to_home);
            }
        });
        btn1 = findViewById(R.id.btn1_les);
        btn2 = findViewById(R.id.btn2_les);
        btn3 = findViewById(R.id.btn3_les);
        btn4 = findViewById(R.id.btn4_les);
        btn5 = findViewById(R.id.btn5_les);
        btn6 = findViewById(R.id.btn6_les);
        btn7 = findViewById(R.id.btn7_les);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Melanocytic_nevus#:~:text=A%20melanocytic%20nevus%20(also%20known,mole%20with%20any%20nevus%20form.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Melanoma#:~:text=Melanoma%2C%20also%20redundantly%20known%20as,or%20eye%20(uveal%20melanoma).";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Seborrheic_keratosis";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.mayoclinic.org/diseases-conditions/basal-cell-carcinoma/symptoms-causes/syc-20354187#:~:text=Basal%20cell%20carcinoma%20is%20a%20type%20of%20skin%20cancer.,it%20can%20take%20other%20forms.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.mayoclinic.org/diseases-conditions/actinic-keratosis/symptoms-causes/syc-20354969";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.ssmhealth.com/cardinal-glennon/pediatric-plastic-reconstructive-surgery/hemangiomas";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://dermnetnz.org/topics/dermatofibroma/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}